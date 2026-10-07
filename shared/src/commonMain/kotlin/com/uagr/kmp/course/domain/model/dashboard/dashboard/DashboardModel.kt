/*
 * DashboardModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.model.dashboard.dashboard

data class DashboardModel(
    val totalBalance: String,
    val monthlyIncome: String,
    val monthlyExpenses: String,
    val monthlySavings: String,
    val savingsRate: String,
    val budgetUsage: String,
    val recentTransactions: List<RecentTransaction>,
    val topExpenseCategories: List<TopExpenseCategory>,
    val goals: List<Goal>
)