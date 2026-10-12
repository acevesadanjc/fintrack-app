/*
 * TransactionsMapper.kt.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.mapper.transactions.transactions

import com.uagr.kmp.course.data.network.model.response.transactions.transactions.Item
import com.uagr.kmp.course.data.network.model.response.transactions.transactions.Pagination
import com.uagr.kmp.course.data.network.model.response.transactions.transactions.TransactionsResponse
import com.uagr.kmp.course.domain.model.transactions.ItemModel
import com.uagr.kmp.course.domain.model.transactions.PaginationModel
import com.uagr.kmp.course.domain.model.transactions.TransactionsModel


fun TransactionsResponse.toDomain() = TransactionsModel(
    items = items?.map { item -> item.toDomain() } ?: emptyList(),
    pagination = pagination?.toDomain() ?: PaginationModel(0, 0, 0, 0)
)

fun Item.toDomain() = ItemModel(
    id = id.orEmpty(),
    accountId = account_id.orEmpty(),
    categoryId = category_id.orEmpty(),
    type = type.orEmpty(),
    amount = amount.orEmpty(),
    currency = currency.orEmpty(),
    description = description.orEmpty(),
    notes = notes.orEmpty(),
    transactionDate = transaction_date.orEmpty(),
    createdAt = created_at.orEmpty(),
    updatedAt = updated_at.orEmpty()
)

fun Pagination.toDomain() = PaginationModel(
    pages = pages ?: 0,
    page = page ?: 0,
    pageSize = page_size ?: 0,
    total = total ?: 0
)