/*
 * LoginMapper.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.mapper.login

import com.uagr.kmp.course.data.network.model.response.login.LoginResponse
import com.uagr.kmp.course.domain.model.login.LoginModel


fun LoginResponse.toDomain() = LoginModel(
    accessToken = accessToken.orEmpty(),
    expiresIn = expiresIn ?: 0,
    refreshToken = refreshToken.orEmpty(),
    tokenType = tokenType.orEmpty()
)