/*
 * TransactionViewModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.feature.transactions.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uagr.kmp.course.core.logger.NapierLogger
import com.uagr.kmp.course.domain.model.base.ErrorDialogModel
import com.uagr.kmp.course.domain.usecase.dashboard.accounts.AccountsUseCase
import com.uagr.kmp.course.domain.usecase.dashboard.dashboard.DashboardUseCase
import com.uagr.kmp.course.domain.usecase.dashboard.dashboard.DashboardValidationsUseCase
import com.uagr.kmp.course.domain.usecase.dashboard.me.MeUseCase
import com.uagr.kmp.course.domain.usecase.transactions.TransactionsUseCase
import com.uagr.kmp.course.presentation.component.item.TransactionItem
import com.uagr.kmp.course.utils.constant.Constants
import com.uagr.kmp.course.utils.network.NetworkResult
import com.uagr.kmp.course.utils.operators.StatusLoading
import course.shared.generated.resources.Res
import course.shared.generated.resources.accept
import course.shared.generated.resources.error
import course.shared.generated.resources.please_try_again_later
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class TransactionViewModel(
    private val napierLogger: NapierLogger,
    private val useCaseTransactions: TransactionsUseCase,
): ViewModel() {

    private var _uiState = MutableStateFlow(TransactionUiState())
    val uiState: StateFlow<TransactionUiState> = _uiState.asStateFlow()

    fun onIntent(intent: TransactionsUiIntent) {
        when (intent) {
            is TransactionsUiIntent.LoadData -> {
                getTransactions()
            }
            is TransactionsUiIntent.SearchChanged -> {

            }
            is TransactionsUiIntent.SearchCleared -> {

            }
            is TransactionsUiIntent.FilterSelected -> {

            }
            is TransactionsUiIntent.TransactionClicked -> {

            }
            is TransactionsUiIntent.AddClicked -> {

            }
            is TransactionsUiIntent.DismissErrorDialog -> {
                dismissDialog()
            }
        }
    }

    fun onFilterChanged(filter: TransactionFilter) {
        _uiState.update { state -> state.copy(selectedFilter = filter) }
    }

    fun onSearchChanged(searchText: String) {
        _uiState.update { state -> state.copy(searchText = searchText) }
    }

    fun getTransactions() = viewModelScope.launch {
        useCaseTransactions.getTransactions().onStart {
            _uiState.update { state -> state.copy(isLoading = StatusLoading.SHOW_LOADING) }
        }.catch {
            _uiState.update { state ->
                state.copy(
                    isLoading = StatusLoading.DISMISS_LOADING,
                    errorDialog = showErrorDialog(),
                )
            }
        }.collect { result ->
            when(result) {
                is NetworkResult.Success -> {

                    val transactions = result.response.items.map { transaction ->
                        TransactionItem(
                            id = transaction.id,
                            title = transaction.description,
                            date = transaction.transactionDate,
                            category = transaction.categoryId,
                            amount = transaction.amount,
                            isIncome = transaction.type == Constants.DEFAULT_INCOME
                        )
                    }

                    _uiState.update { state ->
                        state.copy(
                            isLoading = StatusLoading.DISMISS_LOADING,
                            transactions = transactions
                        )
                    }
                }
                is NetworkResult.Error -> {
                    _uiState.update { state ->
                        state.copy(
                            isLoading = StatusLoading.DISMISS_LOADING,
                            errorDialog = showErrorDialog(result.message),
                        )
                    }
                }
            }
        }
    }

    private suspend fun showErrorDialog(message: String? = null) = ErrorDialogModel(
        title = getString(resource = Res.string.error),
        message = message ?: getString(resource = Res.string.please_try_again_later),
        primaryButtonText = getString(resource = Res.string.accept)
    )

    private fun dismissDialog() = viewModelScope.launch {
        _uiState.update { state -> state.copy(errorDialog = null) }
    }
}
