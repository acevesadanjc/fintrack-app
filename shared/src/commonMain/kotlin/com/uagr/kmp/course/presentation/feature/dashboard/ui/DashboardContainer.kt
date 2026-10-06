/*
 * DashboardNavigation.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.feature.dashboard.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uagr.kmp.course.presentation.component.card.BalanceCard
import com.uagr.kmp.course.presentation.component.card.SummaryStatCard
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.item.TransactionRowItem
import com.uagr.kmp.course.presentation.feature.dashboard.viewmodel.DashboardUiIntent
import com.uagr.kmp.course.presentation.feature.dashboard.viewmodel.DashboardUiState
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
            .padding(horizontal = 20.dp)
    ) {
        // Saludo y Encabezado
        item {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(Res.string.home_Hello) + " ${state.userName}",
                color = Color.Gray,
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = stringResource(Res.string.home_financial_overview),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(20.dp))
        }

        // Tarjeta de Balance Principal
        item {
            BalanceCard(
                totalBalance = state.totalBalance,
                income = state.totalIncome,
                expense = state.totalExpense
            )
            Spacer(modifier = Modifier.height(24.dp))
        }

        // Sección Este Mes (Gastos y Ahorro)
        item {
            Text(
                text = stringResource(Res.string.home_this_month),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                SummaryStatCard(
                    title = stringResource(Res.string.home_expenses),
                    amount = state.monthlyExpense,
                    percentage = state.monthlyExpensePercentage,
                    isPositiveTrend = state.isExpenseDecreasing,
                    modifier = Modifier.weight(1f)
                )
                SummaryStatCard(
                    title = stringResource(Res.string.home_savings),
                    amount = state.monthlySavings,
                    percentage = state.monthlySavingsPercentage,
                    isPositiveTrend = state.isSavingsIncreasing,
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
        }

        // Encabezado de Últimos Movimientos
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(Res.string.home_recent_transactions),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = stringResource(Res.string.home_view_all),
                    color = Color(0xFF2196F3),
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.clickable {
                        onIntent(DashboardUiIntent.OnSeeAllTransactionsClicked)
                    }
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
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
            Spacer(modifier = Modifier.height(100.dp))
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
