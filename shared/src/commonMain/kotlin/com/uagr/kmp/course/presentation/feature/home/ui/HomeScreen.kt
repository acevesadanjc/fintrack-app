/*
 * HomeScreen.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.feature.home.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainer
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest

@Composable
fun HomeScreen(
    //viewModel: RegisterViewModel = koinViewModel(),
    onNavigateToHome: () -> Unit = {},
) {
    SafeScreenContainer(isPaddingNeeded = false) {
/*
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        // Manejo de Effects
        LaunchedEffect(viewModel.uiEffect) {
            viewModel.uiEffect.collect { effect ->
                when (effect) {
                    is RegisterUiEffect.OnRegisterSuccess -> onNavigateToHome()
                }
            }
        }
        */

        //viewModel.initStates()

        HomeContainer(
            /*
            state = uiState,
            onNameChange = { viewModel.onEvent(RegisterUiEvent.OnNameChanged(it)) },
            onEmailChange = { viewModel.onEvent(RegisterUiEvent.OnEmailChanged(it)) },
            onPasswordChange = { viewModel.onEvent(RegisterUiEvent.OnPasswordChanged(it)) },
            onPasswordVisibleChange = { viewModel.onEvent(RegisterUiEvent.OnTogglePasswordVisibility) },
            onConfirmPasswordChange = { viewModel.onEvent(RegisterUiEvent.OnConfirmPasswordChanged(it)) },
            onConfirmPasswordVisibleChange = { viewModel.onEvent(RegisterUiEvent.OnToggleConfirmPasswordVisibility) },
            onRegisterClick = {
                viewModel.onEvent(RegisterUiEvent.OnRegisterClicked)
            }
            */
        )
/*
        if (uiState.isLoading == StatusLoading.SHOW_LOADING) {
            Loader()
        }
        */
/*
        // Si es null se hace dismiss
        DialogCustom(
            errorDialog = uiState.errorDialog,
            titleTextColor = AppTheme.colors.text.black,
            messageTextColor = AppTheme.colors.text.black,
            primaryButtonBackgroundColor = AppTheme.colors.primary,
            primaryButtonTextColor = AppTheme.colors.text.white,
            onPrimaryButtonClick = {
                viewModel.onEvent(RegisterUiEvent.OnDismissErrorDialog)
            }
        )

        */
    }
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_9,
)
@Composable
private fun RegisterScreenPreview() {
    SafeScreenContainerTest(isPaddingNeeded = false) {
        HomeScreen()
    }
}
