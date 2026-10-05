/*
 * RegisterModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.model.register


data class RegisterModel(
    val error: Error,
    val tokens: Tokens,
    val user: User
)