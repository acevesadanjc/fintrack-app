/*
 * AccountsRequest.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.request.dashboard.accounts

import kotlinx.serialization.Serializable

@Serializable
data class AccountsRequest(
    val color: String,
    val currency: String,
    val icon: String,
    val id: String,
    val initial_balance: Int,
    val name: String,
    val type: String
)