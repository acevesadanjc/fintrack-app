/*
 * LoginValidationResult.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.usecase.login


data class LoginValidationResult(
    val passwordError: String? = null
) {

    val isValid: Boolean
        get() = passwordError == null

    val hasError: Boolean
        get() = !isValid

    val message = passwordError
}