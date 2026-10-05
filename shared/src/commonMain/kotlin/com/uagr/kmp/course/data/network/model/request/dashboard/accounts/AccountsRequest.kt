/*
 * AccountsRequest.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.request.dashboard.accounts


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountsRequest(
    @SerialName("color")
    val color: String,
    @SerialName("currency")
    val currency: String,
    @SerialName("icon")
    val icon: String,
    @SerialName("id")
    val id: String,
    @SerialName("initial_balance")
    val initialBalance: Int,
    @SerialName("name")
    val name: String,
    @SerialName("type")
    val type: String
)