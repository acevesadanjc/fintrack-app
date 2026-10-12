/*
 * TransactionContainer.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.feature.transactions.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uagr.kmp.course.presentation.component.button.FilterButton
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.field.TextFieldCustom
import com.uagr.kmp.course.presentation.component.item.TransactionRowItem
import com.uagr.kmp.course.presentation.component.text.TextCustom
import com.uagr.kmp.course.presentation.feature.transactions.viewmodel.TransactionFilter
import com.uagr.kmp.course.presentation.feature.transactions.viewmodel.TransactionUiState
import com.uagr.kmp.course.presentation.feature.transactions.viewmodel.TransactionsUiIntent
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.transactions_filter_all
import course.shared.generated.resources.transactions_filter_expense
import course.shared.generated.resources.transactions_filter_income
import course.shared.generated.resources.transactions_search
import course.shared.generated.resources.transactions_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun TransactionContainer(
    state: TransactionUiState,
    onIntent: (TransactionsUiIntent) -> Unit = {}
) {
    // Filtrado lógico simple
    val movimientosFiltrados = state.transactions.filter { movimiento ->
        val cumpleFiltro = when (state.selectedFilter) {
            TransactionFilter.ALL -> true
            TransactionFilter.INCOME -> movimiento.isIncome
            TransactionFilter.EXPENSE -> !movimiento.isIncome
        }
        val cumpleBusqueda = movimiento.title.contains(state.searchText, ignoreCase = true) ||
                movimiento.category.contains(state.searchText, ignoreCase = true)
        cumpleFiltro && cumpleBusqueda
    }.groupBy { it.date }

    Scaffold(
        containerColor = Color(0xFFF8F9FA),
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Acción para agregar */ },
                containerColor = Color(0xFF1976D2),
                contentColor = AppTheme.colors.backgrounds.white,
                shape = CircleShape
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Agregar movimiento")
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(Dimens.height16)
        ) {
            // Cabecera
            item {
                Spacer(modifier = Modifier.height(Dimens.height16))
                TextCustom(
                    modifier = Modifier,
                    color = AppTheme.colors.text.black,
                    style = AppTheme.typography.bodyBigExtraMicroBold,
                    text = stringResource(Res.string.transactions_title),
                    textAlign = TextAlign.Left
                )
                Spacer(modifier = Modifier.height(Dimens.height8))
                TextCustom(
                    modifier = Modifier,
                    color = AppTheme.colors.text.gray,
                    style = AppTheme.typography.bodySmall,
                    text = state.date,
                    textAlign = TextAlign.Left
                )
                Spacer(modifier = Modifier.height(Dimens.height16))

                // Filtros
                Row(
                    horizontalArrangement = Arrangement.spacedBy(Dimens.width8),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    FilterButton(
                        text = stringResource(Res.string.transactions_filter_all),
                        selected = state.selectedFilter == TransactionFilter.ALL,
                        backgroundColorSelectedButton = AppTheme.colors.primary,
                        textColorSelectedButton = AppTheme.colors.text.white,
                        backgroundColorNotSelectedButton = AppTheme.colors.text.white,
                        textColorNotSelectedButton = AppTheme.colors.primary
                    ) {
                        TransactionsUiIntent.FilterSelected(TransactionFilter.ALL)
                    }

                    FilterButton(
                        text = stringResource(Res.string.transactions_filter_income),
                        selected = state.selectedFilter == TransactionFilter.INCOME,
                        backgroundColorSelectedButton = AppTheme.colors.backgrounds.positiveTrend,
                        textColorSelectedButton = AppTheme.colors.text.positiveTrend,
                        backgroundColorNotSelectedButton = AppTheme.colors.backgrounds.positiveTrend,
                        textColorNotSelectedButton = AppTheme.colors.text.positiveTrend
                    ) {
                        TransactionsUiIntent.FilterSelected(TransactionFilter.INCOME)
                    }

                    FilterButton(
                        text = stringResource(Res.string.transactions_filter_expense),
                        selected = state.selectedFilter == TransactionFilter.EXPENSE,
                        backgroundColorSelectedButton = AppTheme.colors.backgrounds.negativeTrend,
                        textColorSelectedButton = AppTheme.colors.text.negativeTrend,
                        backgroundColorNotSelectedButton = AppTheme.colors.backgrounds.negativeTrend,
                        textColorNotSelectedButton = AppTheme.colors.text.negativeTrend
                    ) {
                        TransactionsUiIntent.FilterSelected(TransactionFilter.EXPENSE)
                    }
                }

                Spacer(modifier = Modifier.height(Dimens.height16))

                TextFieldCustom(
                    value = state.searchText,
                    onValueChange = { TransactionsUiIntent.SearchChanged(it) },
                    labelColor = AppTheme.colors.text.fieldLabel,
                    label = stringResource(Res.string.transactions_search),
                    placeholderColor = AppTheme.colors.text.placeholder,
                    placeholder = stringResource(Res.string.transactions_search),
                    leadingIcon = Icons.Default.Search,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search,
                )
            }

            // Listado agrupado por fecha
            movimientosFiltrados.forEach { (date, transactions) ->
                item {
                    TextCustom(
                        modifier = Modifier.padding(top = Dimens.height8),
                        color = AppTheme.colors.text.gray,
                        style = AppTheme.typography.bodySmallSemiBold,
                        text = date,
                        textAlign = TextAlign.Left
                    )
                }

                items(transactions) { transaction ->
                    TransactionRowItem(transaction = transaction, onClick = {
                        onIntent(TransactionsUiIntent.TransactionClicked(transaction.id))
                    })
                }
            }

            item {
                Spacer(modifier = Modifier.height( Dimens.height64)) // Espacio para el FAB
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
private fun TransactionContainerPreview() {
    SafeScreenContainerTest() {
        TransactionContainer(state = TransactionUiState())
    }
}
