/*
 * AccountsModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.model.dashboard.accounts


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountsModel(
    @SerialName("color")
    val color: String,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("currency")
    val currency: String,
    @SerialName("current_balance")
    val currentBalance: String,
    @SerialName("icon")
    val icon: String,
    @SerialName("id")
    val id: String,
    @SerialName("initial_balance")
    val initialBalance: String,
    @SerialName("is_active")
    val isActive: Boolean,
    @SerialName("name")
    val name: String,
    @SerialName("type")
    val type: String,
    @SerialName("updated_at")
    val updatedAt: String,
    @SerialName("version")
    val version: Int
)