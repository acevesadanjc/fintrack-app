/*
 * DashboardViewModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.feature.dashboard.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uagr.kmp.course.core.logger.NapierLogger
import com.uagr.kmp.course.domain.model.base.ErrorDialogModel
import com.uagr.kmp.course.domain.usecase.dashboard.accounts.AccountsUseCase
import com.uagr.kmp.course.domain.usecase.dashboard.dashboard.DashboardUseCase
import com.uagr.kmp.course.domain.usecase.dashboard.dashboard.DashboardValidationsUseCase
import com.uagr.kmp.course.domain.usecase.dashboard.me.MeUseCase
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
class DashboardViewModel(
    private val napierLogger: NapierLogger,
    private val useCaseAccounts: AccountsUseCase,
    private val useCaseDashboard: DashboardUseCase,
    private val useCaseDashboardValidations: DashboardValidationsUseCase,
    private val useCaseMe: MeUseCase,
): ViewModel() {

    private var _uiState = MutableStateFlow(DashboardUiState())
    val uiState: StateFlow<DashboardUiState> = _uiState.asStateFlow()

    fun onIntent(intent: DashboardUiIntent) {
        when (intent) {
            is DashboardUiIntent.LoadData -> {
                getMe()
            }
            is DashboardUiIntent.OnTransactionClicked -> {
                //sendEffect(DashboardUiEffect.OnNavigateToTransaction(intent.id))
            }
            is DashboardUiIntent.OnSeeAllTransactionsClicked -> {
                //sendEffect(DashboardUiEffect.OnNavigateToTransactions)
            }
            is DashboardUiIntent.OnDismissErrorDialog -> {
                dismissDialog()
            }
        }
    }

    fun getMe() = viewModelScope.launch {
        useCaseMe.getMe().onStart {
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
                    _uiState.update { state -> state.copy(userName = result.response.name) }
                    //accounts(result.response.id)
                    dashboard()
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

    private fun dashboard() = viewModelScope.launch {
        useCaseDashboard.dashboard().catch {
            _uiState.update { state ->
                state.copy(
                    isLoading = StatusLoading.DISMISS_LOADING,
                    errorDialog = showErrorDialog(),
                )
            }
        }.collect { result ->
            when(result) {
                is NetworkResult.Success -> {
                    _uiState.update { state -> state.copy(isLoading = StatusLoading.DISMISS_LOADING) }
                    _uiState.update { state -> state.copy(
                        totalBalance = useCaseDashboardValidations.toCurrency(result.response.totalBalance, true),
                        monthlyIncome = useCaseDashboardValidations.toCurrency(result.response.monthlyIncome, false),
                        monthlyExpenses = useCaseDashboardValidations.toCurrency(result.response.monthlyExpenses, false),
                        monthlySavings = useCaseDashboardValidations.toCurrency(result.response.monthlySavings, false),
                        savingsRatePercentage = "+${result.response.savingsRate}%",
                        expensesRatePercentage = "-${result.response.budgetUsage}%",
                        recentTransactions = result.response.recentTransactions.map { transaction ->
                            TransactionItem(
                                id = transaction.id,
                                title = transaction.description,
                                date = transaction.updatedAt,
                                category = transaction.categoryId,
                                amount = useCaseDashboardValidations.addPositiveOrNegativeSign(
                                    value = useCaseDashboardValidations.toCurrency(transaction.amount, false),
                                    type = transaction.type
                                ),
                                isIncome = useCaseDashboardValidations.isIncome(transaction.type)
                            )
                        }
                    )}
                }
                /*
                    Supermercado description
                    -$860  type amount
                    Hoy created_at · Alimentación category_id
                    */

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

    /*
    private fun getAccounts() = viewModelScope.launch {
        useCaseAccounts.getAccounts().catch {
            _uiState.update { state ->
                state.copy(
                    isLoading = StatusLoading.DISMISS_LOADING,
                    errorDialog = showErrorDialog(),
                )
            }
        }.collect { result ->
            when(result) {
                is NetworkResult.Success -> {
                    //_uiState.update { state -> state.copy(isLoading = StatusLoading.DISMISS_LOADING) }
                    _uiState.update { state -> state.copy(
                        accountName = result.response.items[0].name
                    ) }
                    //summary()
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
    */
/*
    private fun accounts(userId: String) = viewModelScope.launch {
        useCaseAccounts.accounts(
            color = Constants.DEFAULT_COLOR,
            currency = Constants.DEFAULT_CURRENCY,
            icon = Constants.DEFAULT_ICON,
            id = userId,
            initialBalance = Constants.DEFAULT_INITIAL_BALANCE,
            name = Constants.DEFAULT_MAIN_ACCOUNT,
            type = Constants.DEFAULT_TYPE
        ).onStart {
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
                    _uiState.update { state -> state.copy(isLoading = StatusLoading.DISMISS_LOADING) }
                    //dashboard()
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
*/

    private suspend fun showErrorDialog(message: String? = null) = ErrorDialogModel(
        title = getString(resource = Res.string.error),
        message = message ?: getString(resource = Res.string.please_try_again_later),
        primaryButtonText = getString(resource = Res.string.accept)
    )

    private fun dismissDialog() = viewModelScope.launch {
        _uiState.update { state -> state.copy(errorDialog = null) }
    }

}
