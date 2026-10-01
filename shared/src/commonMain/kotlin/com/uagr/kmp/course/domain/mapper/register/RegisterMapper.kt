/*
 * RegisterMapper.kt.kt
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
        accessToken = tokens?.accessToken.orEmpty(),
        refreshToken = tokens?.refreshToken.orEmpty(),
        tokenType = tokens?.tokenType.orEmpty(),
        expiresIn = tokens?.expiresIn ?: 0
    ),
    user = User(
        currency = user?.currency.orEmpty(),
        email = user?.email.orEmpty(),
        emailVerified = user?.emailVerified ?: false,
        id = user?.id.orEmpty(),
        isActive = user?.isActive ?: false,
        locale = user?.locale.orEmpty(),
        name = user?.name.orEmpty()
    )
)