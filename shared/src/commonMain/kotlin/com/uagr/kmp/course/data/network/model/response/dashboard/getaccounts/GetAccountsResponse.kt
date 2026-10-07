/*
 * GetAccountsResponse.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.response.dashboard.getaccounts

import com.uagr.kmp.course.data.network.model.response.base.BaseResponse
import kotlinx.serialization.Serializable

@Serializable
data class GetAccountsResponse(
    val items: List<Item>?,
    val pagination: Pagination?
): BaseResponse()