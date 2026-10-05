/*
 * MainScreen.kt
 *
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.main.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.uagr.kmp.course.presentation.component.navigation.TabNavigationItem
import com.uagr.kmp.course.presentation.main.navigation.BudgetTab
import com.uagr.kmp.course.presentation.main.navigation.GoalTab
import com.uagr.kmp.course.presentation.main.navigation.HomeTab
import com.uagr.kmp.course.presentation.main.navigation.TransactionTab
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    TabNavigator(HomeTab) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { },
                    actions = { // Icono derecha
                        IconButton(
                            onClick = {

                            }
                        ) {
                            Icon(
                                modifier = Modifier.size(Dimens.height48),
                                imageVector = Icons.Default.MoreHoriz,
                                tint = AppTheme.colors.backgrounds.black,
                                contentDescription = null
                            )
                        }
                    },
                    navigationIcon = { }, // Icono izquierda
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.background,
                        actionIconContentColor = MaterialTheme.colorScheme.background
                    )
                )
            },
            bottomBar = {
                NavigationBar(
                    modifier = Modifier
                        .padding(horizontal = Dimens.padding16)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(Dimens.corner24)),
                    containerColor = AppTheme.colors.backgrounds.white,
                ) {
                    TabNavigationItem(HomeTab)
                    TabNavigationItem(TransactionTab)
                    TabNavigationItem(BudgetTab)
                    TabNavigationItem(GoalTab)
                }
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                CurrentTab()
            }
        }
    }
}