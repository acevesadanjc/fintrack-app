/*
 * AccountsMapper.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.mapper.dashboard.accounts

import com.uagr.kmp.course.data.network.model.response.dashboard.accounts.AccountsResponse
import com.uagr.kmp.course.domain.model.dashboard.accounts.AccountsModel


fun AccountsResponse.toDomain() = AccountsModel(
    color = color.orEmpty(),
    createdAt = created_at.orEmpty(),
    currency = currency.orEmpty(),
    currentBalance = current_balance.orEmpty(),
    icon = icon.orEmpty(),
    id = id.orEmpty(),
    initialBalance = initial_balance.orEmpty(),
    isActive = is_active ?: false,
    name = name.orEmpty(),
    type = type.orEmpty(),
    updatedAt = updated_at.orEmpty(),
    version = version ?: 0
)