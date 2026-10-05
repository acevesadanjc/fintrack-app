/*
 * AccountsResponse.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.response.dashboard.accounts


import com.uagr.kmp.course.data.network.model.response.base.BaseResponse
import kotlinx.serialization.Serializable

@Serializable
data class AccountsResponse(
    val color: String?,
    val created_at: String?,
    val currency: String?,
    val current_balance: String?,
    val icon: String?,
    val id: String?,
    val initial_balance: String?,
    val is_active: Boolean?,
    val name: String?,
    val type: String?,
    val updated_at: String?,
    val version: Int?,
) : BaseResponse()