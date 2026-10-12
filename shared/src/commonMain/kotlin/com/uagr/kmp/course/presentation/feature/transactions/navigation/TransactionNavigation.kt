/*
 * TransactionNavigation.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.feature.transactions.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import com.uagr.kmp.course.presentation.feature.transactions.ui.TransactionScreen

data object TransactionNavigation : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalTabNavigator.current

        TransactionScreen(
            onNavigateToAddTransaction = {

            }
        )
    }
}