/*
 * LoginValidationResult.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.usecase.login

import org.jetbrains.compose.resources.StringResource


data class LoginValidationResult(
    val passwordError: StringResource? = null
) {

    val isValid: Boolean
        get() = passwordError == null

    val hasError: Boolean
        get() = !isValid

    val message = passwordError
}