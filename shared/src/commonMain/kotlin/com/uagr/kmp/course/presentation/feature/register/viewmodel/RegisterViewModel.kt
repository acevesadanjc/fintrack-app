/*
 * RegisterViewModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.feature.register.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uagr.kmp.course.domain.model.base.ErrorDialogModel
import com.uagr.kmp.course.domain.usecase.register.RegisterUseCase
import com.uagr.kmp.course.domain.usecase.register.RegisterValidationUseCase
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
class RegisterViewModel(
    private val registerUseCase: RegisterUseCase,
    private val validationsUseCse: RegisterValidationUseCase,
): ViewModel() {

    // Un solo StateFlow para toda la pantalla
    private var _uiState = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState.asStateFlow()

    // Canal para eventos de un solo disparo (navegación)
    private val _uiEffect = Channel<RegisterUiEffect>()
    val uiEffect = _uiEffect.receiveAsFlow()

    /**
     * Helper para enviar effect hacia la UI
     */
    private fun sendEffect(effect: RegisterUiEffect) {
        viewModelScope.launch {
            _uiEffect.send(effect)
        }
    }

    /*
    fun initStates() {
        _uiState.update { state ->
            state.copy(
                name = "Test Name",
                password = "Testing123*",
                confirmPassword = "Testing123*",
            )
        }
    }
    */

    /**
     * Único punto de entrada de la UI hacia el ViewModel
     */
    fun onEvent(event: RegisterUiEvent) {
        when (event) {
            is RegisterUiEvent.OnNameChanged -> updateName(event.name)
            is RegisterUiEvent.OnEmailChanged -> updateEmail(event.email)
            is RegisterUiEvent.OnPasswordChanged -> updatePassword(event.password)
            is RegisterUiEvent.OnTogglePasswordVisibility -> updatePasswordVisible(uiState.value.isPasswordVisible.not())
            is RegisterUiEvent.OnConfirmPasswordChanged -> updateConfirmPassword(event.confirmPassword)
            is RegisterUiEvent.OnToggleConfirmPasswordVisibility -> updateConfirmPasswordVisible(uiState.value.isConfirmPasswordVisible.not())
            is RegisterUiEvent.OnRegisterClicked -> validateFields()
            is RegisterUiEvent.OnDismissErrorDialog -> dismissDialog()
            is RegisterUiEvent.OnRegisterNavigateBack -> sendEffect(RegisterUiEffect.OnRegisterNavigateBack)
        }
    }

    private fun updateName(name: String) = viewModelScope.launch {
        _uiState.update { state -> state.copy(name = name) }
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

    private fun updateConfirmPassword(confirmPassword: String) = viewModelScope.launch {
        _uiState.update { state -> state.copy(confirmPassword = confirmPassword) }
    }

    private fun updateConfirmPasswordVisible(isConfirmPasswordVisible: Boolean) = viewModelScope.launch {
        _uiState.update { state -> state.copy(isConfirmPasswordVisible = isConfirmPasswordVisible) }
    }

    private fun validateFields() {
        viewModelScope.launch {
            val validateFields = validationsUseCse.invoke(
                password = uiState.value.password,
                confirmPassword = uiState.value.confirmPassword
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
                register()
            }
        }
    }

    private fun register() = viewModelScope.launch {
        registerUseCase.register(
            email = uiState.value.email,
            name = uiState.value.name,
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
                    sendEffect(RegisterUiEffect.OnRegisterSuccess)
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
