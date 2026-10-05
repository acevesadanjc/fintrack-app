/*
 * LoginViewModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.feature.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uagr.kmp.course.domain.model.base.ErrorDialogModel
import com.uagr.kmp.course.domain.usecase.login.LoginUseCase
import com.uagr.kmp.course.domain.usecase.login.LoginValidationUseCase
import com.uagr.kmp.course.utils.network.NetworkResult
import com.uagr.kmp.course.utils.operators.StatusLoading
import course.shared.generated.resources.Res
import course.shared.generated.resources.accept
import course.shared.generated.resources.error
import course.shared.generated.resources.please_try_again_later
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class LoginViewModel(
    private val useCase: LoginUseCase,
    private val validationsUseCase: LoginValidationUseCase,
): ViewModel() {

    private var _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    private val _uiEffect = Channel<LoginUiEffect>()
    val uiEffect = _uiEffect.receiveAsFlow()

    private fun sendEffect(effect: LoginUiEffect) {
        viewModelScope.launch {
            _uiEffect.send(effect)
        }
    }

    fun initStates() {
        _uiState.update { state ->
            state.copy(
                email = "test010@gmail.com",
                password = "Testing123*",
            )
        }
    }

    fun onEvent(event: LoginUiEvent) {
        when (event) {
            is LoginUiEvent.OnEmailChanged -> updateEmail(event.email)
            is LoginUiEvent.OnPasswordChanged -> updatePassword(event.password)
            is LoginUiEvent.OnTogglePasswordVisibility -> updatePasswordVisible(uiState.value.isPasswordVisible.not())
            is LoginUiEvent.OnLoginClicked -> validateFields()
            is LoginUiEvent.OnRegisterClicked -> sendEffect(LoginUiEffect.OnNavigateToRegister)
            is LoginUiEvent.OnDismissErrorDialog -> dismissDialog()
        }
    }

    private fun updateEmail(email: String) = viewModelScope.launch {
        _uiState.update { state -> state.copy(email = email) }
    }

    private fun updatePassword(password: String) = viewModelScope.launch {
        _uiState.update { state -> state.copy(password = password) }
    }

    private fun updatePasswordVisible(isPasswordVisible: Boolean) = viewModelScope.launch {
        _uiState.update { state -> state.copy(isPasswordVisible = isPasswordVisible) }
    }


    private fun validateFields() {
        viewModelScope.launch {
            val validateFields = validationsUseCase.invoke(
                password = uiState.value.password
            )
            if (validateFields.hasError) {
                _uiState.update { state ->
                    state.copy(
                        errorDialog = showErrorDialog(
                            validateFields.message.orEmpty()
                        )
                    )
                }
            } else {
                login()
            }
        }
    }

    private fun login() = viewModelScope.launch {
        useCase.login(
            email = uiState.value.email,
            password = uiState.value.password
        ).onStart {
            _uiState.update { state -> state.copy(isLoading = StatusLoading.SHOW_LOADING) }
        }.catch {
            _uiState.update { state ->
                state.copy(
                    isLoading = StatusLoading.DISMISS_LOADING,
                    errorDialog = showErrorDialog(),
                )
            }
        }.collect { result ->
            when(result) {
                is NetworkResult.Success -> {
                    _uiState.update { state -> state.copy(isLoading = StatusLoading.DISMISS_LOADING) }
                    sendEffect(LoginUiEffect.OnLoginSuccess)
                }
                is NetworkResult.Error -> {
                    _uiState.update { state ->
                        state.copy(
                            isLoading = StatusLoading.DISMISS_LOADING,
                            errorDialog = showErrorDialog(result.message),
                        )
                    }
                }
            }
        }
    }

    private suspend fun showErrorDialog(message: String? = null) = ErrorDialogModel(
        title = getString(resource = Res.string.error),
        message = message ?: getString(resource = Res.string.please_try_again_later),
        primaryButtonText = getString(resource = Res.string.accept)
    )

    private fun dismissDialog() = viewModelScope.launch {
        _uiState.update { state -> state.copy(errorDialog = null) }
    }
}
