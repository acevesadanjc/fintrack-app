/*
 * LoginValidationUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.usecase.login

import org.koin.core.annotation.Factory

@Factory
class LoginValidationUseCase {

    operator fun invoke(
        password: String
    ): LoginValidationResult {
        var passwordError: String? = null

        if (password.isEmpty()) {
            passwordError = "El campo password no puede estar vacio."
        }

        return LoginValidationResult(passwordError = passwordError)
    }
}