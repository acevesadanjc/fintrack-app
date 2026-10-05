/*
 * MainNavigation.kt
 *
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.main.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.uagr.kmp.course.presentation.main.ui.MainScreen

data object MainNavigation : Screen {
    @Composable
    override fun Content() {
        MainScreen()
    }
}