/*
 * NavigationController.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.feature.root

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.uagr.kmp.course.presentation.feature.login.navigation.LoginNavigation
import com.uagr.kmp.course.presentation.theme.AppTheme

@Composable
fun NavigationController() {
    AppTheme {
        Navigator(screen = LoginNavigation) { navigator ->
            SlideTransition(navigator)
        }
    }
}
