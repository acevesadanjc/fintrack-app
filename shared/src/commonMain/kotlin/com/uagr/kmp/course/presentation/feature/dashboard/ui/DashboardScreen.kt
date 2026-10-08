/*
 * DashboardScreen.kt
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
import com.uagr.kmp.course.presentation.component.loader.Loader
import com.uagr.kmp.course.presentation.feature.dashboard.viewmodel.DashboardUiIntent
import com.uagr.kmp.course.presentation.feature.dashboard.viewmodel.DashboardUiState
import com.uagr.kmp.course.presentation.feature.dashboard.viewmodel.DashboardViewModel
import com.uagr.kmp.course.presentation.theme.AppTheme
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = koinViewModel(),
    onNavigateToTransaction: () -> Unit = {}
) {
    SafeScreenContainer(isPaddingNeeded = false) {

        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        LaunchedEffect(viewModel) {
            viewModel.onIntent(DashboardUiIntent.LoadData)
        }

        DashboardContainer(
            state = uiState,
            onIntent = { intent ->
                when (intent) {
                    is DashboardUiIntent.OnSeeAllTransactionsClicked -> {
                        onNavigateToTransaction()
                    }
                    is DashboardUiIntent.OnTransactionClicked -> {
                    }
                    else -> {}
                }
            }
        )

        Loader(isLoading = uiState.isLoading)

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
