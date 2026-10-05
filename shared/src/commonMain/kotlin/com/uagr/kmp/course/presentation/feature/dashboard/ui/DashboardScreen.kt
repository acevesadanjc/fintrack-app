/*
 * HomeScreen.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.feature.dashboard.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainer
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.dialog.DialogCustom
import com.uagr.kmp.course.presentation.feature.dashboard.viewmodel.DashboardUiEffect
import com.uagr.kmp.course.presentation.feature.dashboard.viewmodel.DashboardUiIntent
import com.uagr.kmp.course.presentation.feature.dashboard.viewmodel.DashboardUiState
import com.uagr.kmp.course.presentation.feature.dashboard.viewmodel.DashboardViewModel
import com.uagr.kmp.course.presentation.feature.dashboard.viewmodel.TransactionItem
import com.uagr.kmp.course.presentation.theme.AppTheme
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = koinViewModel(),
    onNavigateToHome: () -> Unit = {},
) {
    SafeScreenContainer(isPaddingNeeded = false) {

        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        LaunchedEffect(viewModel) {
            //viewModel.getMe()
        }

        LaunchedEffect(viewModel.uiEffect) {
            viewModel.uiEffect.collect { effect ->
                when (effect) {
                    is DashboardUiEffect.OnAssociatedAccount -> onNavigateToHome()
                }
            }
        }

        val mockState = DashboardUiState(
            userName = "Diego",
            totalBalance = "$24,860.00",
            totalIncome = "+$18,500",
            totalExpense = "-$8,460",
            monthlyExpense = "$8,460",
            monthlyExpensePercentage = "12%",
            isExpenseDecreasing = false,
            monthlySavings = "$3,120",
            monthlySavingsPercentage = "8%",
            isSavingsIncreasing = true,
            recentTransactions = listOf(
                TransactionItem("1", "Supermercado", "Hoy", "Alimentación", "-$860", isIncome = false),
                TransactionItem("2", "Nómina", "Ayer", "Ingreso", "+$15,500", isIncome = true),
                TransactionItem("3", "Internet", "18 sep", "Servicios", "-$599", isIncome = false)
            )
        )

        //viewModel.initStates()

        DashboardContainer(
            state = uiState,
            onIntent = { intent ->
                when (intent) {
                    is DashboardUiIntent.OnSeeAllTransactionsClicked -> { /* Navegar a ver todos */ }
                    is DashboardUiIntent.OnTransactionClicked -> { /* Navegar a detalle */ }
                    else -> {}
                }
            }
        )

        /*
        if (uiState.isLoading == StatusLoading.SHOW_LOADING) {
            Loader()
        }
        */


        // Si es null se hace dismiss
        DialogCustom(
            errorDialog = uiState.errorDialog,
            titleTextColor = AppTheme.colors.text.black,
            messageTextColor = AppTheme.colors.text.black,
            primaryButtonBackgroundColor = AppTheme.colors.primary,
            primaryButtonTextColor = AppTheme.colors.text.white,
            onPrimaryButtonClick = {
                viewModel.onIntent(DashboardUiIntent.OnDismissErrorDialog)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DashboardPreview() {
    SafeScreenContainerTest() {
        DashboardContainer(state = DashboardUiState())
    }
}
