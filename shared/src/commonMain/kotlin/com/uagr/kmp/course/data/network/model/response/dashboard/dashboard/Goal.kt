/*
 * Goal.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.response.dashboard.dashboard

import kotlinx.serialization.Serializable

@Serializable
data class Goal(
    val id: String?,
    val name: String?,
    val target_amount: String?,
    val current_amount: String?,
    val target_date: String?,
    val status: String?,
    val created_at: String?,
    val updated_at: String?,
    val version: Int?
)