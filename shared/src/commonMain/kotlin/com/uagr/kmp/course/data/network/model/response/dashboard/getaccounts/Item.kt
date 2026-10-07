/*
 * Item.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.response.dashboard.getaccounts

import kotlinx.serialization.Serializable

@Serializable
data class Item(
    val id: String?,
    val name: String?,
    val type: String?,
    val currency: String?,
    val initial_balance: String?,
    val current_balance: String?,
    val color: String?,
    val icon: String?,
    val is_active: Boolean?,
    val created_at: String?,
    val updated_at: String?,
    val version: Int?
)