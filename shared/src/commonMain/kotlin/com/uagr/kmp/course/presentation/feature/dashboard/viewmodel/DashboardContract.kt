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
    val userName: String = "",
    val totalBalance: String = "",
    val totalIncome: String = "",
    val totalExpense: String = "",
    val monthlyExpense: String = "",
    val monthlyExpensePercentage: String = "",
    val isExpenseDecreasing: Boolean = false,
    val monthlySavings: String = "",
    val monthlySavingsPercentage: String = "",
    val isSavingsIncreasing: Boolean = false,
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

