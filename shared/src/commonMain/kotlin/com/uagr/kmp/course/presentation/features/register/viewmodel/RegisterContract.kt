/*
 * RegisterContract.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.features.register.viewmodel

import com.uagr.kmp.course.domain.model.base.ErrorDialogModel
import com.uagr.kmp.course.utils.operators.StatusLoading


/**
 * Contrato centralizado para la pantalla de Registro de Usuario bajo la arquitectura MVI (Model-View-Intent).
 *
 * Agrupa de forma unificada la definición de nivel superior completa del contrato visual:
 * - [RegisterUiEvent]: Acciones enviadas por el usuario hacia el ViewModel (UI -> ViewModel).
 * - [RegisterUiState]: Estado inmutable consumido para renderizar la UI (ViewModel -> UI).
 * - [RegisterUiEffect]: Eventos únicos de un solo disparo (ViewModel -> UI).
 */

/**
 * Representa todas las acciones e intenciones de usuario (Intents) emitidas desde la UI hacia el ViewModel.
 *
 *  Ejemplo: OnLoginClicked, OnEmailChanged(val email: String), OnRetryClicked.
 */
sealed interface RegisterUiEvent {
    data class OnNameChanged(val name: String) : RegisterUiEvent
    data class OnEmailChanged(val email: String) : RegisterUiEvent
    data class OnPasswordChanged(val password: String) : RegisterUiEvent
    data object OnTogglePasswordVisibility : RegisterUiEvent
    data class OnConfirmPasswordChanged(val confirmPassword: String) : RegisterUiEvent
    data object OnToggleConfirmPasswordVisibility : RegisterUiEvent
    data object OnRegisterClicked : RegisterUiEvent
    data object OnRegisterNavigateBack : RegisterUiEvent
    data object OnDismissErrorDialog : RegisterUiEvent
}

/**
 * Representa la información que maneja la pantalla del estado visual de la pantalla (State).
 */
data class RegisterUiState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false,
    val confirmPassword: String = "",
    val isConfirmPasswordVisible: Boolean = false,
    val isLoading: StatusLoading = StatusLoading.DISMISS_LOADING,
    val errorDialog: ErrorDialogModel? = null,
)

/**
 * Representa efectos secundarios (Side Effects) de un solo disparo que la UI debe ejecutar.
 *
 * A diferencia del [RegisterUiState], estos eventos no perduran en memoria ni se re-emiten
 * tras eventos de recomposición o cambios de configuración (como la rotación de pantalla).
 */
sealed interface RegisterUiEffect {
    data object OnRegisterSuccess : RegisterUiEffect
    data object OnRegisterNavigateBack : RegisterUiEffect
}