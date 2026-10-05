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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uagr.kmp.course.presentation.feature.dashboard.viewmodel.TransactionItem

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
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Dot / Icon Container
        val circleBg = if (transaction.isIncome) Color(0xFFE8F5E9) else Color(0xFFFFEBEE)
        val dotColor = if (transaction.isIncome) Color(0xFF4CAF50) else Color(0xFFE53935)

        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(circleBg),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(dotColor)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Title and Category/Date
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = transaction.title,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black
            )
            Text(
                text = "${transaction.date} · ${transaction.category}",
                color = Color.Gray,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        // Amount
        Text(
            text = transaction.amount,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyLarge,
            color = if (transaction.isIncome) Color(0xFF4CAF50) else Color(0xFFE53935)
        )
    }
}

@Composable
@Preview
private fun BalanceCardPreview() {
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