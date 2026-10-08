/*
 * DashboardContainer.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.feature.dashboard.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.presentation.component.card.BalanceCard
import com.uagr.kmp.course.presentation.component.card.SummaryStatCard
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.item.TransactionRowItem
import com.uagr.kmp.course.presentation.component.text.TextButtonCustom
import com.uagr.kmp.course.presentation.component.text.TextCustom
import com.uagr.kmp.course.presentation.feature.dashboard.viewmodel.DashboardUiIntent
import com.uagr.kmp.course.presentation.feature.dashboard.viewmodel.DashboardUiState
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.home_Hello
import course.shared.generated.resources.home_expenses
import course.shared.generated.resources.home_financial_overview
import course.shared.generated.resources.home_recent_transactions
import course.shared.generated.resources.home_savings
import course.shared.generated.resources.home_this_month
import course.shared.generated.resources.home_view_all
import org.jetbrains.compose.resources.stringResource

@Composable
fun DashboardContainer(
    state: DashboardUiState,
    onIntent: (DashboardUiIntent) -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Dimens.height24)
    ) {
        // Saludo y Encabezado
        item {
            Spacer(modifier = Modifier.height(Dimens.height16))
            TextCustom(
                modifier = Modifier.fillMaxWidth(),
                color = AppTheme.colors.text.gray,
                style = AppTheme.typography.bodyNormalExtra,
                text = stringResource(Res.string.home_Hello) + " ${state.userName}",
                textAlign = TextAlign.Left
            )
            Spacer(modifier = Modifier.height(Dimens.height4))
            TextCustom(
                modifier = Modifier.fillMaxWidth(),
                color = AppTheme.colors.text.black,
                style = AppTheme.typography.bodyBigExtraMicroBold,
                text = stringResource(Res.string.home_financial_overview),
                textAlign = TextAlign.Left
            )
            Spacer(modifier = Modifier.height(Dimens.height20))
        }
        // Tarjeta de Balance Principal
        item {
            BalanceCard(
                totalBalance = state.totalBalance,
                income = state.monthlyIncome,
                expense = state.monthlyExpenses
            )
            Spacer(modifier = Modifier.height(Dimens.height24))
        }

        // Sección Este Mes (Gastos y Ahorro)
        item {
            TextCustom(
                modifier = Modifier.fillMaxWidth(),
                color = AppTheme.colors.text.black,
                style = AppTheme.typography.bodyMediumExtraBold,
                text = stringResource(Res.string.home_this_month),
                textAlign = TextAlign.Left
            )
            Spacer(modifier = Modifier.height(Dimens.height12))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(Dimens.height12)
            ) {
                SummaryStatCard(
                    title = stringResource(Res.string.home_expenses),
                    amount = state.monthlyExpenses,
                    percentage = state.expensesRatePercentage,
                    isPositiveTrend = state.isExpenseDecreasing,
                    modifier = Modifier.weight(1f)
                )
                SummaryStatCard(
                    title = stringResource(Res.string.home_savings),
                    amount = state.monthlySavings,
                    percentage = state.savingsRatePercentage,
                    isPositiveTrend = state.isSavingsIncreasing,
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(Dimens.height24))
        }
        // Encabezado de Últimos Movimientos
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextCustom(
                    modifier = Modifier,
                    color = AppTheme.colors.text.black,
                    style = AppTheme.typography.bodyMediumExtraSemiBold,
                    text = stringResource(Res.string.home_recent_transactions),
                    textAlign = TextAlign.Left
                )
                TextButtonCustom(
                    modifier = Modifier,
                    color = AppTheme.colors.primary,
                    text = stringResource(Res.string.home_view_all),
                    textStyle = AppTheme.typography.bodySmallExtraSemiBold,
                    onClick = {
                        onIntent(DashboardUiIntent.OnSeeAllTransactionsClicked)
                    }
                )
            }
            Spacer(modifier = Modifier.height(Dimens.height8))
        }

        // Lista de Transacciones
        items(state.recentTransactions, key = { it.id }) { item ->
            TransactionRowItem(
                transaction = item,
                onClick = { onIntent(DashboardUiIntent.OnTransactionClicked(item.id)) }
            )
        }

        // Espaciador final para que el último elemento no quede tapado por la barra de navegación flotante
        item {
            Spacer(modifier = Modifier.height(Dimens.height96))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DashboardContainerPreview() {
    SafeScreenContainerTest() {
        DashboardContainer(state = DashboardUiState())
    }
}
