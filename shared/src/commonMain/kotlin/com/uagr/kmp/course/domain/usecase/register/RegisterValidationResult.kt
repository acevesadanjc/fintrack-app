/*
 * ValidateRegisterUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.usecase.register

import org.jetbrains.compose.resources.StringResource


/**
 * Encapsula el resultado de las validaciones de negocio aplicadas al formulario de registro.
 */
data class RegisterValidationResult(
    val passwordError: StringResource? = null,
    val confirmPasswordError: StringResource? = null,
) {
    /**
     * Indica si la totalidad del formulario es válido para ser enviado.
     *
     * Retorna `true` únicamente si todos los campos de error son `null`.
     */
    val isValid: Boolean
        get() = passwordError == null &&
                confirmPasswordError == null

    /**
     * Indica si existe al menos un error de validación en el formulario.
     */
    val hasError: Boolean
        get() = !isValid

    val message = passwordError ?: confirmPasswordError
}