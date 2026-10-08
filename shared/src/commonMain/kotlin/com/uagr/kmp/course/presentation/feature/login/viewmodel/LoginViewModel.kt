/*
 * LoginViewModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.feature.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uagr.kmp.course.domain.model.base.ErrorDialogModel
import com.uagr.kmp.course.domain.usecase.login.LoginLocalUseCase
import com.uagr.kmp.course.domain.usecase.login.LoginRemoteUseCase
import com.uagr.kmp.course.domain.usecase.login.LoginValidationUseCase
import com.uagr.kmp.course.utils.network.NetworkResult
import com.uagr.kmp.course.utils.operators.StatusLoading
import course.shared.generated.resources.Res
import course.shared.generated.resources.accept
import course.shared.generated.resources.error
import course.shared.generated.resources.please_try_again_later
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class LoginViewModel(
    private val useCaseRemote: LoginRemoteUseCase,
    private val validationsUseCase: LoginValidationUseCase,
    private val useCaseLocal: LoginLocalUseCase,
): ViewModel() {

    private val _loginUiState = MutableStateFlow(LoginUiState())
    val loginUiState: StateFlow<LoginUiState> = _loginUiState.asStateFlow()

    fun initStates() {
        _loginUiState.update { state ->
            state.copy(
                email = "test011@gmail.com",
                password = "Password123*",
            )
        }
    }

    fun onEvent(event: LoginUiEvent) {
        when (event) {
            is LoginUiEvent.Idle -> {}
            is LoginUiEvent.OnEmailChanged -> updateEmail(event.email)
            is LoginUiEvent.OnPasswordChanged -> updatePassword(event.password)
            is LoginUiEvent.OnTogglePasswordVisibility -> updatePasswordVisible(loginUiState.value.isPasswordVisible.not())
            is LoginUiEvent.OnLoginClicked -> validateFields()
            is LoginUiEvent.OnRegisterClicked -> {
               //_loginUiEvent.value = LoginUiEvent.OnRegisterClicked
                _loginUiState.update { state -> state.copy(navigationTarget = LoginNavigationTarget.Register) }
            }
            is LoginUiEvent.OnDismissErrorDialog -> dismissDialog()
            is LoginUiEvent.OnSuccessLogin -> {}
            is LoginUiEvent.NavigationHandled -> {
                _loginUiState.update { state -> state.copy(navigationTarget = null) }
            }
        }
    }

    private fun updateEmail(email: String) = viewModelScope.launch {
        _loginUiState.update { state -> state.copy(email = email) }
    }

    private fun updatePassword(password: String) = viewModelScope.launch {
        _loginUiState.update { state -> state.copy(password = password) }
    }

    private fun updatePasswordVisible(isPasswordVisible: Boolean) = viewModelScope.launch {
        _loginUiState.update { state -> state.copy(isPasswordVisible = isPasswordVisible) }
    }


    private fun validateFields() {
        viewModelScope.launch {
            val validateFields = validationsUseCase.invoke(
                password = loginUiState.value.password
            )
            if (validateFields.hasError) {
                val errorMessage = validateFields.message?.let { getString(it) }.orEmpty()
                _loginUiState.update { state ->
                    state.copy(
                        errorDialog = showErrorDialog(
                            errorMessage
                        )
                    )
                }
            } else {
                login()
            }
        }
    }

    private fun login() = viewModelScope.launch {
        useCaseRemote.login(
            email = loginUiState.value.email,
            password = loginUiState.value.password
        ).onStart {
            _loginUiState.update { state -> state.copy(isLoading = StatusLoading.SHOW_LOADING) }
        }.catch {
            _loginUiState.update { state ->
                state.copy(
                    isLoading = StatusLoading.DISMISS_LOADING,
                    errorDialog = showErrorDialog(),
                )
            }
        }.collect { result ->
            when(result) {
                is NetworkResult.Success -> {
                    saveAccessToken(accessToken = result.response.accessToken)
                }
                is NetworkResult.Error -> {
                    _loginUiState.update { state ->
                        state.copy(
                            isLoading = StatusLoading.DISMISS_LOADING,
                            errorDialog = showErrorDialog(result.message),
                        )
                    }
                }
            }
        }
    }

    private fun saveAccessToken(accessToken: String) = viewModelScope.launch {
        useCaseLocal.saveAccessToken(accessToken = accessToken).catch {
            _loginUiState.update { state ->
                state.copy(
                    isLoading = StatusLoading.DISMISS_LOADING,
                    errorDialog = showErrorDialog(),
                )
            }
        }.collect {
            _loginUiState.update { state -> state.copy(isLoading = StatusLoading.DISMISS_LOADING) }
            _loginUiState.update { state -> state.copy(navigationTarget = LoginNavigationTarget.Home) }
        }
    }

    private suspend fun showErrorDialog(message: String? = null) = ErrorDialogModel(
        title = getString(resource = Res.string.error),
        message = message ?: getString(resource = Res.string.please_try_again_later),
        primaryButtonText = getString(resource = Res.string.accept)
    )

    private fun dismissDialog() = viewModelScope.launch {
        _loginUiState.update { state -> state.copy(errorDialog = null) }
    }

}
