/*
 * RegisterScreen.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.feature.register.ui

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
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.feature.register.viewmodel.RegisterUiEffect
import com.uagr.kmp.course.presentation.feature.register.viewmodel.RegisterUiEvent
import com.uagr.kmp.course.presentation.feature.register.viewmodel.RegisterUiState
import com.uagr.kmp.course.presentation.feature.register.viewmodel.RegisterViewModel
import com.uagr.kmp.course.utils.flow.CollectWithLifecycle
import com.uagr.kmp.course.utils.operators.StatusLoading
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel = koinViewModel(),
    onNavigateToHome: () -> Unit = {},
    onNavigateBack: () -> Unit = {},
) {
    SafeScreenContainer {
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

/*
        viewModel.uiState.CollectWithLifecycle() {

        }
*/
        // Manejo de Effects
        LaunchedEffect(viewModel.uiEffect) {
            viewModel.uiEffect.collect { effect ->
                when (effect) {
                    is RegisterUiEffect.OnRegisterSuccess -> onNavigateToHome()
                    is RegisterUiEffect.OnRegisterNavigateBack -> onNavigateBack()
                }
            }
        }

        //viewModel.initStates()

        RegisterContainer(
            state = uiState,
            onNameChange = { viewModel.onEvent(RegisterUiEvent.OnNameChanged(it)) },
            onEmailChange = { viewModel.onEvent(RegisterUiEvent.OnEmailChanged(it)) },
            onPasswordChange = { viewModel.onEvent(RegisterUiEvent.OnPasswordChanged(it)) },
            onPasswordVisibleChange = { viewModel.onEvent(RegisterUiEvent.OnTogglePasswordVisibility) },
            onConfirmPasswordChange = { viewModel.onEvent(RegisterUiEvent.OnConfirmPasswordChanged(it)) },
            onConfirmPasswordVisibleChange = { viewModel.onEvent(RegisterUiEvent.OnToggleConfirmPasswordVisibility) },
            onRegisterClick = {
                viewModel.onEvent(RegisterUiEvent.OnRegisterClicked)
            },
            onNavigateBackClick = {
                viewModel.onEvent(RegisterUiEvent.OnRegisterNavigateBack)
            }
        )

        Loader(isLoading = uiState.isLoading)

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
    }
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_9,
)
@Composable
private fun RegisterScreenPreview() {
    SafeScreenContainerTest {
        RegisterContainer(
            state = RegisterUiState(),
        )
    }
}
