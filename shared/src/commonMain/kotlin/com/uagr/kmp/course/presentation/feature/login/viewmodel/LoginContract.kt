/*
 * RegisterContract.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.feature.login.viewmodel

import com.uagr.kmp.course.domain.model.base.ErrorDialogModel
import com.uagr.kmp.course.utils.operators.StatusLoading

sealed interface LoginUiEvent {
    data class OnEmailChanged(val email: String) : LoginUiEvent
    data class OnPasswordChanged(val password: String) : LoginUiEvent
    data object OnTogglePasswordVisibility : LoginUiEvent
    data object OnLoginClicked : LoginUiEvent
    data object OnRegisterClicked : LoginUiEvent
    data object OnDismissErrorDialog : LoginUiEvent
}

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false,
    val isLoading: StatusLoading = StatusLoading.DISMISS_LOADING,
    val errorDialog: ErrorDialogModel? = null,
)

sealed interface LoginUiEffect {
    data object OnLoginSuccess : LoginUiEffect
    data object OnNavigateToRegister : LoginUiEffect
}