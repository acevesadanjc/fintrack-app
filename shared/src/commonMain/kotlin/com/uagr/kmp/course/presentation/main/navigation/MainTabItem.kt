/*
 * MainTabItem.kt
 *
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.main.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Savings
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.SlideTransition
import com.uagr.kmp.course.presentation.feature.home.navigation.HomeNavigation
import course.shared.generated.resources.Res
import course.shared.generated.resources.main_tab_budget
import course.shared.generated.resources.main_tab_goal
import course.shared.generated.resources.main_tab_home
import course.shared.generated.resources.main_tab_transactions
import org.jetbrains.compose.resources.stringResource

object HomeTab: Tab {
    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Default.Home)
            val title = stringResource(Res.string.main_tab_home)
            val index: UShort = 0u

            return remember {
                TabOptions(
                    index = index,
                    title = title,
                    icon = icon
                )
            }
        }
    @Composable
    override fun Content() {
        // Navigation anidado
        Navigator(screen = HomeNavigation) { navigator ->
            SlideTransition(navigator)
        }
    }
}

object TransactionTab: Tab {
    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Default.SwapHoriz)
            val title = stringResource(Res.string.main_tab_transactions)
            val index: UShort = 1u

            return TabOptions(
                index = index,
                title = title,
                icon = icon
            )
        }

    @Composable
    override fun Content() {
        GenericScreen("Transactions Page")
        /*
        Navigator(screen = TransactionNavigation) { navigator ->
            SlideTransition(navigator)
        }
        */
    }
}

object BudgetTab: Tab {
    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Default.AccountBalanceWallet)
            val title = stringResource(Res.string.main_tab_budget)
            val index: UShort = 2u

            return TabOptions(
                index = index,
                title = title,
                icon = icon
            )
        }

    @Composable
    override fun Content() {
        GenericScreen("Budgets Page")
        /*
        Navigator(screen = BudgetNavigation) { navigator ->
            SlideTransition(navigator)
        }
        */
    }
}

object GoalTab: Tab {
    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Default.Savings)
            val title = stringResource(Res.string.main_tab_goal)
            val index: UShort = 3u

            return TabOptions(
                index = index,
                title = title,
                icon = icon
            )
        }

    @Composable
    override fun Content() {
        GenericScreen("Goals Page")
        /*
        Navigator(screen = GoalsNavigation) { navigator ->
            SlideTransition(navigator)
        }
        */
    }
}


@Composable
private fun GenericScreen(name: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = name)
    }
}