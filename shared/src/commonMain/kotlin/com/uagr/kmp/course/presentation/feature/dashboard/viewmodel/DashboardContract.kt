/*
 * HomeContract.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.feature.dashboard.viewmodel

import com.uagr.kmp.course.domain.model.base.ErrorDialogModel
import com.uagr.kmp.course.domain.model.dashboard.dashboard.RecentTransaction
import com.uagr.kmp.course.utils.operators.StatusLoading


sealed interface DashboardUiIntent {
    data object LoadData : DashboardUiIntent
    data object OnSeeAllTransactionsClicked : DashboardUiIntent
    data class OnTransactionClicked(val id: String) : DashboardUiIntent
    object OnDismissErrorDialog : DashboardUiIntent
}

data class DashboardUiState(
    val userName: String = "",
    val totalBalance: String = "",
    val monthlyIncome: String = "",
    val monthlyExpenses: String = "",
    val monthlySavings: String = "",
    val savingsRatePercentage: String = "",
    val expensesRatePercentage : String = "",
    val isExpenseDecreasing: Boolean = false,
    val isSavingsIncreasing: Boolean = true,
    val recentTransactions: List<TransactionItem> = emptyList(),
    val isLoading: StatusLoading = StatusLoading.DISMISS_LOADING,
    val errorDialog: ErrorDialogModel? = null
)
/*
Supermercado description
-$860  type amount
Hoy created_at · Alimentación category_id
*/

data class TransactionItem(
    val id: String,
    val title: String,
    val date: String,
    val category: String,
    val amount: String,
    val isIncome: Boolean
)
