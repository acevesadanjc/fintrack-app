/*
 * LoginModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.model.login


data class LoginModel(
    val accessToken: String,
    val expiresIn: Int,
    val refreshToken: String,
    val tokenType: String
)