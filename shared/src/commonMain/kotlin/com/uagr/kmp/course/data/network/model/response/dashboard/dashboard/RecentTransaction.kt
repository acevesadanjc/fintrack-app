/*
 * RecentTransaction.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.response.dashboard.dashboard

import kotlinx.serialization.Serializable

@Serializable
data class RecentTransaction(
    val id: String?,
    val account_id: String?,
    val category_id: String?,
    val type: String?,
    val amount: String?,
    val currency: String?,
    val description: String?,
    val notes: String?,
    val transaction_date: String?,
    val created_at: String?,
    val updated_at: String?,
    val version: Int?
    )