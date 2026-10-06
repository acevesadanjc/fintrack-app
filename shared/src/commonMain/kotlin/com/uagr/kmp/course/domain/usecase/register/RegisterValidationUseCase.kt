/*
 * RegisterValidationUseCase.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.usecase.register

import course.shared.generated.resources.Res
import course.shared.generated.resources.register_field_meessage_password_not_match
import course.shared.generated.resources.register_field_message_password_not_empty
import org.jetbrains.compose.resources.StringResource
import org.koin.core.annotation.Factory

@Factory
class RegisterValidationUseCase {

    operator fun invoke(
        password: String,
        confirmPassword: String
    ): RegisterValidationResult {
        var passwordError: StringResource? = null
        var confirmPasswordError: StringResource? = null

        if (password.isEmpty() || confirmPassword.isEmpty()) {
            passwordError = Res.string.register_field_message_password_not_empty
        } else if (password != confirmPassword) {
            confirmPasswordError = Res.string.register_field_meessage_password_not_match
        }

        return RegisterValidationResult(
            passwordError = passwordError,
            confirmPasswordError = confirmPasswordError
        )
    }
}