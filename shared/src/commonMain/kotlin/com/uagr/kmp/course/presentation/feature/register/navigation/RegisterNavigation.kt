/*
 * RegisterNavigation.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.feature.register.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.uagr.kmp.course.presentation.feature.register.ui.RegisterScreen
import com.uagr.kmp.course.presentation.main.navigation.MainNavigation

data object RegisterNavigation : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        RegisterScreen(
            onNavigateToHome = {
                navigator.replaceAll(item = MainNavigation)
            },
            onNavigateBack = {
                if (navigator.canPop) {
                    navigator.pop()
                }
            }
        )
    }
}
