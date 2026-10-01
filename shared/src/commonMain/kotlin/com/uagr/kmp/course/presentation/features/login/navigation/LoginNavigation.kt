/*
 * LoginNavigation.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.features.login.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.uagr.kmp.course.presentation.features.home.navigation.HomeNavigation
import com.uagr.kmp.course.presentation.features.login.ui.LoginScreen
import com.uagr.kmp.course.presentation.features.register.navigation.RegisterNavigation

data object LoginNavigation : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        LoginScreen(
            onNavigateToRegister = {
                navigator.push(item = RegisterNavigation)
            },
            onNavigateToHome = {
                navigator.replaceAll(item = HomeNavigation)
            }
        )
    }
}
