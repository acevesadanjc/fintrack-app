/*
 * HomeNavigation.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.feature.dashboard.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import com.uagr.kmp.course.presentation.feature.dashboard.ui.DashboardScreen
import com.uagr.kmp.course.presentation.main.navigation.TransactionTab

data object HomeNavigation : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalTabNavigator.current

        DashboardScreen(
            onNavigateToTransaction = {
                navigator.current = TransactionTab
            }
        )
    }
}