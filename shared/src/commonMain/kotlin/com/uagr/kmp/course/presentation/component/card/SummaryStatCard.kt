/*
 * SummaryStatCard.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.component.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.text.TextCustom
import com.uagr.kmp.course.presentation.feature.dashboard.ui.DashboardContainer
import com.uagr.kmp.course.presentation.feature.dashboard.viewmodel.DashboardUiState
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.home_this_month
import org.jetbrains.compose.resources.stringResource

@Composable
fun SummaryStatCard(
    title: String,
    amount: String,
    percentage: String,
    isPositiveTrend: Boolean,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(Dimens.height20),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(Dimens.padding16)) {
            TextCustom(
                modifier = Modifier,
                color = AppTheme.colors.text.gray,
                style = AppTheme.typography.bodySmallExtra,
                text = title,
                textAlign = TextAlign.Left
            )
            Spacer(modifier = Modifier.height(Dimens.height8))
            TextCustom(
                modifier = Modifier,
                color = AppTheme.colors.text.black,
                style = AppTheme.typography.bodyBigBold,
                text = amount,
                textAlign = TextAlign.Left
            )
            Spacer(modifier = Modifier.height(Dimens.height8))
            Row(verticalAlignment = Alignment.CenterVertically) {
                val trendColor = if (isPositiveTrend) AppTheme.colors.text.positiveTrend else AppTheme.colors.text.negativeTrend
                Icon(
                    imageVector = if (isPositiveTrend) Icons.Default.ArrowUpward else Icons.Default.ArrowDownward,
                    contentDescription = null,
                    tint = trendColor,
                    modifier = Modifier.height(Dimens.height14)
                )
                Spacer(modifier = Modifier.width(Dimens.width4))
                TextCustom(
                    modifier = Modifier,
                    color = trendColor,
                    style = AppTheme.typography.bodySmallExtraSemiBold,
                    text = percentage,
                    textAlign = TextAlign.Left
                )
            }
        }
    }
}

@Composable
@Preview
private fun SummaryStatCardPreview() {
    SafeScreenContainerTest( backgroundColor = AppTheme.colors.text.black) {
        SummaryStatCard(
            title = "Balance total",
            amount = "$24,860.00",
            percentage = "+12.5%",
            isPositiveTrend = true
        )
    }
}