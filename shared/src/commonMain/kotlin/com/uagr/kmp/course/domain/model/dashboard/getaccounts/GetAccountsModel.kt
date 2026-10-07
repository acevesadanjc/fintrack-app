/*
 * GetAccountsModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.model.dashboard.getaccounts

data class GetAccountsModel(
    val items: List<Item>,
    val pagination: Pagination
)