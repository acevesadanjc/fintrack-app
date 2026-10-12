/*
 * TransactionsModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.model.transactions

data class TransactionsModel(
    val items: List<ItemModel>,
    val pagination: PaginationModel
)