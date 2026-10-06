/*
 * MeMapper.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.mapper.dashboard.me

import com.uagr.kmp.course.data.network.model.response.dashboard.me.MeResponse
import com.uagr.kmp.course.domain.model.dashboard.me.MeModel


fun MeResponse.toDomain() = MeModel(
    id = id,
    name = name,
    email = email,
    currency = currency,
    timezone = timezone,
    locale = locale,
    isActive = is_active,
    emailVerified = email_verified
)