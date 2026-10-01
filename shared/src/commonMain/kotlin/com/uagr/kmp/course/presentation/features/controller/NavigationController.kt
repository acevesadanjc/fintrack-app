/*
 * NavigationController.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.features.controller

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.ScaleTransition
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.features.welcome.navigation.WelcomeNavigation

@Composable
fun NavigationController() {
    AppTheme {
        Navigator(screen = WelcomeNavigation) { navigator ->
            ScaleTransition(navigator)
        }
    }
}
