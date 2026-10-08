/*
 * TransactionRowItem.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.component.item

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.text.TextCustom
import com.uagr.kmp.course.presentation.feature.dashboard.viewmodel.TransactionItem
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens

@Composable
fun TransactionRowItem(
    transaction: TransactionItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = Dimens.padding12),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Dot / Icon Container
        val circleBg = if (transaction.isIncome) AppTheme.colors.backgrounds.positiveTrend else AppTheme.colors.backgrounds.negativeTrend
        val dotColor = if (transaction.isIncome) AppTheme.colors.text.positiveTrend else AppTheme.colors.text.negativeTrend

        Box(
            modifier = Modifier
                .size(Dimens.height48)
                .clip(CircleShape)
                .background(circleBg),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(Dimens.height8)
                    .clip(CircleShape)
                    .background(dotColor)
            )
        }

        Spacer(modifier = Modifier.width(Dimens.width16))

        // Title and Category/Date
        Column(modifier = Modifier.weight(1f)) {
            TextCustom(
                modifier = Modifier,
                color = AppTheme.colors.text.black,
                style = AppTheme.typography.bodySmallSemiBold,
                text = transaction.title,
                textAlign = TextAlign.Left
            )
            TextCustom(
                modifier = Modifier,
                color = AppTheme.colors.text.gray,
                style = AppTheme.typography.bodyTiny,
                text = "${transaction.date} · ${transaction.category}",
                textAlign = TextAlign.Left
            )
        }

        // Amount
        TextCustom(
            modifier = Modifier,
            color = if (transaction.isIncome) AppTheme.colors.text.positiveTrend else AppTheme.colors.text.negativeTrend,
            style = AppTheme.typography.bodySmallSemiBold,
            text = transaction.amount,
            textAlign = TextAlign.Left
        )
    }
}

@Composable
@Preview
private fun BalanceCardPreview() {
    SafeScreenContainerTest {
        TransactionRowItem(
            transaction = TransactionItem(
                id = "1",
                title = "Salario",
                date = "2024-06-01",
                category = "Ingresos",
                amount = "+$3,000.00",
                isIncome = true
            ),
            onClick = {}
        )
    }
}