/*
 * ValidateRegisterUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.usecase.register

import org.koin.core.annotation.Factory

@Factory
class ValidateRegisterUseCase {

    operator fun invoke(
        password: String,
        confirmPassword: String
    ): RegisterValidationResult {
        var passwordError: String? = null
        var confirmPasswordError: String? = null

        if (password.isEmpty() || confirmPassword.isEmpty()) {
            passwordError = "Las contraseñas no pueden estar vacías."
        } else if (password != confirmPassword) {
            confirmPasswordError = "Las contraseñas no coinciden."
        }

        return RegisterValidationResult(
            passwordError = passwordError,
            confirmPasswordError = confirmPasswordError
        )
    }
}