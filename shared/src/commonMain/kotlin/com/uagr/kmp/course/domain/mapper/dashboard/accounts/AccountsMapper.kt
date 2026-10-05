/*
 * AccountsMapper.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.mapper.dashboard.accounts

import com.uagr.kmp.course.data.network.model.response.dashboard.accounts.AccountsResponse
import com.uagr.kmp.course.domain.model.dashboard.accounts.AccountsModel


fun AccountsResponse.toDomain() = AccountsModel(
    color = color.orEmpty(),
    createdAt = createdAt.orEmpty(),
    currency = currency.orEmpty(),
    currentBalance = currentBalance.orEmpty(),
    icon = icon.orEmpty(),
    id = id.orEmpty(),
    initialBalance = initialBalance.orEmpty(),
    isActive = isActive ?: false,
    name = name.orEmpty(),
    type = type.orEmpty(),
    updatedAt = updatedAt.orEmpty(),
    version = version ?: 0
)