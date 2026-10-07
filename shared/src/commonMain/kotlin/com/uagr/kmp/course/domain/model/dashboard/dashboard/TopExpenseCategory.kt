/*
 * TopExpenseCategory.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.model.dashboard.dashboard

data class TopExpenseCategory(
    val categoryId: String,
    val categoryName: String,
    val amount: String,
    val percentage: String
)