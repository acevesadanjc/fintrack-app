/*
 * LoginValidationUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.usecase.login

import course.shared.generated.resources.Res
import course.shared.generated.resources.login_field_message
import org.jetbrains.compose.resources.StringResource
import org.koin.core.annotation.Factory

@Factory
class LoginValidationUseCase {

    operator fun invoke(
        password: String
    ): LoginValidationResult {
        var passwordError: StringResource? = null

        if (password.isEmpty()) {
            passwordError = Res.string.login_field_message
        }

        return LoginValidationResult(passwordError = passwordError)
    }
}