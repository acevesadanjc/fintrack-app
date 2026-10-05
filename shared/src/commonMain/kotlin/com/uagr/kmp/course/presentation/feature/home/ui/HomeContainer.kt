/*
 * HomeContainer.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.feature.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.presentation.component.button.ButtonCustom
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.text.TextCustom
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.home_logout
import org.jetbrains.compose.resources.stringResource


@Composable
fun HomeContainer(
    /*
    state: RegisterUiState,
    onNameChange: (String) -> Unit = {},
    onEmailChange: (String) -> Unit = {},
    onPasswordChange: (String) -> Unit = {},
    onPasswordVisibleChange: (Boolean) -> Unit = {},
    onConfirmPasswordChange: (String) -> Unit = {},
    onConfirmPasswordVisibleChange: (Boolean) -> Unit = {},
    onRegisterClick: () -> Unit = {},
    */
) {

    //val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Dimens.padding24)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(Dimens.height16))

        TextCustom(
            modifier = Modifier.fillMaxWidth(),
            style = AppTheme.typography.bodyNormal,
            color = AppTheme.colors.text.gray,
            text = "Hola, Juan",
            textAlign = TextAlign.Left
        )

        Spacer(modifier = Modifier.height(Dimens.height8))

        TextCustom(
            modifier = Modifier.fillMaxWidth(),
            color = AppTheme.colors.text.black,
            style = AppTheme.typography.bodyBigSemiBold,
            text = "Tu panorama financiero",
            textAlign = TextAlign.Left
        )

        Spacer(modifier = Modifier.height(Dimens.height32))

        ButtonCustom(
            onClick = {  },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Dimens.padding64),
            backgroundButton = AppTheme.colors.primary,
            textColor = AppTheme.colors.text.white,
            text = stringResource(Res.string.home_logout),
            textAlign = TextAlign.Left
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun RegisterContainerPreview() {
    SafeScreenContainerTest() {
        HomeContainer()
    }
}
