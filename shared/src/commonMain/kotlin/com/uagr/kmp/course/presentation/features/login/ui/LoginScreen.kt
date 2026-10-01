/*
 * LoginScreen.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.features.login.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainer
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.dialog.DialogCustom
import com.uagr.kmp.course.presentation.component.loader.Loader
import com.uagr.kmp.course.presentation.features.login.viewmodel.LoginUiEffect
import com.uagr.kmp.course.presentation.features.login.viewmodel.LoginUiEvent
import com.uagr.kmp.course.presentation.features.login.viewmodel.LoginViewModel
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.utils.operators.StatusLoading
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = koinViewModel(),
    onNavigateToRegister: () -> Unit = {},
    onNavigateToHome: () -> Unit = {},
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel.uiEffect) {
        viewModel.uiEffect.collect { effect ->
            when (effect) {
                is LoginUiEffect.OnLoginSuccess -> onNavigateToHome()
                is LoginUiEffect.OnNavigateToRegister -> onNavigateToRegister()
            }
        }
    }

    SafeScreenContainer {
        LoginContainer(
            state = uiState,
            onEmailChange = { viewModel.onEvent(LoginUiEvent.OnEmailChanged(it)) },
            onPasswordChange = { viewModel.onEvent(LoginUiEvent.OnPasswordChanged(it)) },
            onPasswordVisibleChange = { viewModel.onEvent(LoginUiEvent.OnTogglePasswordVisibility) },
            onLoginClick = {
                viewModel.onEvent(LoginUiEvent.OnLoginClicked)
            },
            onRegisterClick = {
                viewModel.onEvent(LoginUiEvent.OnRegisterClicked)
            }
        )

        if (uiState.isLoading == StatusLoading.SHOW_LOADING) {
            Loader(isLoading = uiState.isLoading)
        }

        DialogCustom(
            errorDialog = uiState.errorDialog,
            titleTextColor = AppTheme.colors.text.black,
            messageTextColor = AppTheme.colors.text.black,
            primaryButtonBackgroundColor = AppTheme.colors.primary,
            primaryButtonTextColor = AppTheme.colors.text.white,
            onPrimaryButtonClick = {
                viewModel.onEvent(LoginUiEvent.OnDismissErrorDialog)
            }
        )
    }
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_9,
)
@Composable
private fun LoginScreenScreenPreview() {
    SafeScreenContainerTest {
        LoginScreen()
    }
}
