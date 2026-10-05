/*
 * TabNavigationItem.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.component.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import com.uagr.kmp.course.presentation.component.text.TextCustom
import com.uagr.kmp.course.presentation.theme.AppTheme

@Composable
fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    NavigationBarItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        icon = {
            tab.options.icon?.let { iconPainter ->
                Icon(painter = iconPainter, contentDescription = tab.options.title)
            }
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = AppTheme.colors.primary,
            unselectedIconColor = AppTheme.colors.text.gray,
            indicatorColor = AppTheme.colors.backgrounds.indicator,
            selectedTextColor = AppTheme.colors.primary,
            unselectedTextColor = AppTheme.colors.text.gray
        ),
        label = {
            TextCustom(
                modifier = Modifier.fillMaxWidth(),
                color = null,
                style = AppTheme.typography.bodyTinySemiBold,
                text = tab.options.title,
                textAlign = TextAlign.Center
            )
        }
    )
}