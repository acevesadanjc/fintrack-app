/*
 * HomeContract.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.feature.dashboard.viewmodel

import com.uagr.kmp.course.domain.model.base.ErrorDialogModel
import com.uagr.kmp.course.utils.operators.StatusLoading


sealed interface DashboardUiIntent {
    data object LoadData : DashboardUiIntent
    data object OnSeeAllTransactionsClicked : DashboardUiIntent
    data class OnTransactionClicked(val id: String) : DashboardUiIntent
    object OnDismissErrorDialog : DashboardUiIntent
}

data class DashboardUiState(
    val userName: String = "Diego",
    val totalBalance: String = "$24,860.00",
    val totalIncome: String = "+$18,500",
    val totalExpense: String = "-$8,460",
    val monthlyExpense: String = "$8,460",
    val monthlyExpensePercentage: String = "12%",
    val isExpenseDecreasing: Boolean = true,
    val monthlySavings: String = "$3,120",
    val monthlySavingsPercentage: String = "8%",
    val isSavingsIncreasing: Boolean = true,
    val recentTransactions: List<TransactionItem> = emptyList(),
    val isLoading: StatusLoading = StatusLoading.DISMISS_LOADING,
    val errorDialog: ErrorDialogModel? = null
)

data class TransactionItem(
    val id: String,
    val title: String,
    val date: String,
    val category: String,
    val amount: String,
    val isIncome: Boolean
)

sealed interface DashboardUiEffect {
    data object OnAssociatedAccount : DashboardUiEffect
    //data object OnNavigateToRegister : HomeUiEffect
}

