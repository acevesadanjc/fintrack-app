/*
 * DashboardMapper.kt.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.domain.mapper.dashboard.dashboard

import com.uagr.kmp.course.data.network.model.response.dashboard.dashboard.DashboardResponse
import com.uagr.kmp.course.domain.model.dashboard.dashboard.DashboardModel
import com.uagr.kmp.course.domain.model.dashboard.dashboard.Goal
import com.uagr.kmp.course.domain.model.dashboard.dashboard.RecentTransaction
import com.uagr.kmp.course.domain.model.dashboard.dashboard.TopExpenseCategory

fun DashboardResponse.toDomain() = DashboardModel(
    totalBalance = total_balance.orEmpty(),
    monthlyIncome = monthly_income.orEmpty(),
    monthlyExpenses = monthly_expenses.orEmpty(),
    monthlySavings = monthly_savings.orEmpty(),
    savingsRate = savings_rate.orEmpty(),
    budgetUsage = budget_usage.orEmpty(),
    recentTransactions = recent_transactions?.map { it.toDomain() }.orEmpty(),
    topExpenseCategories = top_expense_categories?.map { it.toDomain() }.orEmpty(),
    goals = goals?.map { it.toDomain() }.orEmpty(),
)

fun com.uagr.kmp.course.data.network.model.response.dashboard.dashboard.RecentTransaction.toDomain() =
    RecentTransaction(
        id = id.orEmpty(),
        accountId = account_id.orEmpty(),
        categoryId = category_id.orEmpty(),
        type = type.orEmpty(),
        amount = amount.orEmpty(),
        currency = currency.orEmpty(),
        description = description.orEmpty(),
        notes = notes.orEmpty(),
        transactionDate = transaction_date.orEmpty(),
        createdAt = created_at.orEmpty(),
        updatedAt = updated_at.orEmpty(),
        version = version ?: 0
    )

fun com.uagr.kmp.course.data.network.model.response.dashboard.dashboard.TopExpenseCategory.toDomain() =
    TopExpenseCategory(
        categoryId = category_id.orEmpty(),
        categoryName = category_name.orEmpty(),
        amount = amount.orEmpty(),
        percentage = percentage.orEmpty(),
    )

fun com.uagr.kmp.course.data.network.model.response.dashboard.dashboard.Goal.toDomain() = Goal(
    id = id.orEmpty(),
    name = name.orEmpty(),
    targetAmount = target_amount.orEmpty(),
    currentAmount = current_amount.orEmpty(),
    targetDate = target_date.orEmpty(),
    status = status.orEmpty(),
    createdAt = created_at.orEmpty(),
    updatedAt = updated_at.orEmpty(),
    version = version ?: 0
)