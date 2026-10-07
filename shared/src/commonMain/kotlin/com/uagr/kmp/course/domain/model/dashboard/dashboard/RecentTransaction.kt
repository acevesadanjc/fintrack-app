/*
 * RecentTransaction.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.model.dashboard.dashboard

data class RecentTransaction(
    val id: String,
    val accountId: String,
    val categoryId: String,
    val type: String,
    val amount: String,
    val currency: String,
    val description: String,
    val notes: String,
    val transactionDate: String,
    val createdAt: String,
    val updatedAt: String,
    val version: Int
)