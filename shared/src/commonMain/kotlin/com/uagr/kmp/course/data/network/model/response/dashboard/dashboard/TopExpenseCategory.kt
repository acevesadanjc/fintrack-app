/*
 * TopExpenseCategory.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.response.dashboard.dashboard

import kotlinx.serialization.Serializable

@Serializable
data class TopExpenseCategory(
    val category_id: String?,
    val category_name: String?,
    val amount: String?,
    val percentage: String?
)