/*
 * BalanceCard.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.component.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.text.TextCustom
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.home_expenses
import course.shared.generated.resources.home_income
import course.shared.generated.resources.home_total_balance
import org.jetbrains.compose.resources.stringResource

@Composable
fun BalanceCard(
    accountName: String,
    totalBalance: String,
    income: String,
    expense: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(Dimens.padding24),
        colors = CardDefaults.cardColors(
            containerColor = AppTheme.colors.text.blueMedium
        )
    ) {
        Column(modifier = Modifier.padding(Dimens.padding24)) {
            TextCustom(
                modifier = Modifier,
                color = AppTheme.colors.text.white.copy(alpha = 0.8f),
                style = AppTheme.typography.bodySmallExtra,
                text = accountName,
                textAlign = TextAlign.Left
            )
            Spacer(modifier = Modifier.height(Dimens.height8))
            TextCustom(
                modifier = Modifier,
                color = AppTheme.colors.text.white,
                style = AppTheme.typography.bodyBigExtraLargeBold,
                text = totalBalance,
                textAlign = TextAlign.Left
            )
            Spacer(modifier = Modifier.height(Dimens.height24))
            Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.weight(1f)) {
                    TextCustom(
                        modifier = Modifier,
                        color = AppTheme.colors.text.white.copy(alpha = 0.8f),
                        style = AppTheme.typography.bodySmallExtra,
                        text = stringResource(Res.string.home_income),
                        textAlign = TextAlign.Left
                    )
                    Spacer(modifier = Modifier.height(Dimens.height4))
                    TextCustom(
                        modifier = Modifier,
                        color = AppTheme.colors.text.white,
                        style = AppTheme.typography.bodySmallSemiBold,
                        text = income,
                        textAlign = TextAlign.Left
                    )
                }
                Column(modifier = Modifier.weight(1f)) {
                    TextCustom(
                        modifier = Modifier,
                        color = AppTheme.colors.text.white.copy(alpha = 0.8f),
                        style = AppTheme.typography.bodySmallExtra,
                        text = stringResource(Res.string.home_expenses),
                        textAlign = TextAlign.Left
                    )
                    Spacer(modifier = Modifier.height(Dimens.height4))
                    TextCustom(
                        modifier = Modifier,
                        color = AppTheme.colors.text.white,
                        style = AppTheme.typography.bodySmallSemiBold,
                        text = expense,
                        textAlign = TextAlign.Left
                    )
                }
            }
        }
    }
}

@Composable
@Preview
private fun BalanceCardPreview() {
    SafeScreenContainerTest() {
        BalanceCard(
            accountName = "Cuenta debito",
            totalBalance = "$24,860.00",
            income = "+$18,500",
            expense = "-$8,460"
        )
    }
}