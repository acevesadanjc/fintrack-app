/*
 * TransactionItem.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.component.item

data class TransactionItem(
    val id: String,
    val title: String,
    val date: String,
    val category: String,
    val amount: String,
    val isIncome: Boolean
)