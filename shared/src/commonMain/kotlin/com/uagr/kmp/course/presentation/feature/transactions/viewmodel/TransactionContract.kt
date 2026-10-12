/*
 * TransactionContract.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.feature.transactions.viewmodel

import com.uagr.kmp.course.domain.model.base.ErrorDialogModel
import com.uagr.kmp.course.presentation.component.item.TransactionItem
import com.uagr.kmp.course.utils.operators.StatusLoading

/*
data class TransactionItem(
    val id: String,
    val title: String,
    val date: String,
    val category: String,
    val amount: String,
    val isIncome: Boolean
)
*/

enum class TransactionFilter {
    ALL, INCOME, EXPENSE
}

data class TransactionUiState(
    val transactions: List<TransactionItem> = emptyList(),
    val selectedFilter: TransactionFilter = TransactionFilter.ALL,
    val searchText: String = "",
    val date: String = "Septiembre 2026",
    val isLoading: StatusLoading = StatusLoading.DISMISS_LOADING,
    val errorDialog: ErrorDialogModel? = null
)

sealed interface TransactionsUiIntent {
    data object LoadData : TransactionsUiIntent
    data class SearchChanged(val query: String) : TransactionsUiIntent
    data object SearchCleared : TransactionsUiIntent
    data class FilterSelected(val filter: TransactionFilter) : TransactionsUiIntent
    data class TransactionClicked(val id: String) : TransactionsUiIntent
    data object AddClicked : TransactionsUiIntent
    data object DismissErrorDialog : TransactionsUiIntent
}