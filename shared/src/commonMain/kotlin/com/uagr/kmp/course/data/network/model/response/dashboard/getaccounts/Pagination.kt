/*
 * Pagination.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.response.dashboard.getaccounts

import kotlinx.serialization.Serializable

@Serializable
data class Pagination(
    val page: Int?,
    val page_size: Int?,
    val pages: Int?,
    val total: Int?
)