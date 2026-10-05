/*
 * AccountsModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.model.dashboard.accounts


data class AccountsModel(
    val color: String,
    val createdAt: String,
    val currency: String,
    val currentBalance: String,
    val icon: String,
    val id: String,
    val initialBalance: String,
    val isActive: Boolean,
    val name: String,
    val type: String,
    val updatedAt: String,
    val version: Int
)