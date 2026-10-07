/*
 * DashboardResponse.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.response.dashboard.dashboard

import com.uagr.kmp.course.data.network.model.response.base.BaseResponse
import kotlinx.serialization.Serializable

@Serializable
data class DashboardResponse(
    val total_balance: String?,
    val monthly_income: String?,
    val monthly_expenses: String?,
    val monthly_savings: String?,
    val savings_rate: String?,
    val budget_usage: String?,
    val recent_transactions: List<RecentTransaction>?,
    val top_expense_categories: List<TopExpenseCategory>?,
    val goals: List<Goal>?
) : BaseResponse()