/*
 * PaginationModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.model.transactions

data class PaginationModel(
    val page: Int,
    val pageSize: Int,
    val pages: Int,
    val total: Int
)