/*
 * Pagination.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.model.dashboard.getaccounts

data class Pagination(
    val page: Int,
    val pageSize: Int,
    val pages: Int,
    val total: Int
)