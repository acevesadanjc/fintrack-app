/*
 * RegisterMapper.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.mapper.register

import com.uagr.kmp.course.data.network.model.response.register.RegisterResponse
import com.uagr.kmp.course.domain.model.register.Error
import com.uagr.kmp.course.domain.model.register.RegisterModel
import com.uagr.kmp.course.domain.model.register.Tokens
import com.uagr.kmp.course.domain.model.register.User


fun RegisterResponse.toDomain() = RegisterModel(
    error = Error(
        code = error?.code.orEmpty(),
        message = error?.message.orEmpty()
    ),
    tokens = Tokens(
        accessToken = tokens?.access_token.orEmpty(),
        refreshToken = tokens?.refresh_token.orEmpty(),
        tokenType = tokens?.token_type.orEmpty(),
        expiresIn = tokens?.expires_in ?: 0
    ),
    user = User(
        currency = user?.currency.orEmpty(),
        email = user?.email.orEmpty(),
        emailVerified = user?.email_verified ?: false,
        id = user?.id.orEmpty(),
        isActive = user?.is_active ?: false,
        locale = user?.locale.orEmpty(),
        name = user?.name.orEmpty()
    )
)