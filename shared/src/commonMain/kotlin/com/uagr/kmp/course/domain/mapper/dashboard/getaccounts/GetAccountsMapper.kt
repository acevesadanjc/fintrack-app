/*
 * GetAccountsResponse.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.mapper.dashboard.getaccounts

import com.uagr.kmp.course.data.network.model.response.dashboard.getaccounts.GetAccountsResponse
import com.uagr.kmp.course.domain.model.dashboard.getaccounts.GetAccountsModel
import com.uagr.kmp.course.domain.model.dashboard.getaccounts.Item
import com.uagr.kmp.course.domain.model.dashboard.getaccounts.Pagination


fun GetAccountsResponse.toDomain() = GetAccountsModel(
    items = items?.map { it.toDomain() }.orEmpty(),
    pagination = pagination?.toDomain() ?: Pagination(0, 0, 0, 0),
)

fun com.uagr.kmp.course.data.network.model.response.dashboard.getaccounts.Item.toDomain() =
    Item(
        id = id.orEmpty(),
        name = name.orEmpty(),
        type = type.orEmpty(),
        currency = currency.orEmpty(),
        initialBalance = initial_balance.orEmpty(),
        currentBalance = current_balance.orEmpty(),
        color = color.orEmpty(),
        icon = icon.orEmpty(),
        isActive = is_active ?: false,
        createdAt = created_at.orEmpty(),
        updatedAt = updated_at.orEmpty(),
        version = version ?: 0
    )

fun com.uagr.kmp.course.data.network.model.response.dashboard.getaccounts.Pagination.toDomain() =
    Pagination(
        page = page ?: 0,
        pageSize = page_size ?: 0,
        pages = pages ?: 0,
        total = total ?: 0
    )
