/*
 * LoginContainer.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.feature.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.presentation.component.button.ButtonCustom
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.field.TextFieldCustom
import com.uagr.kmp.course.presentation.component.field.TextFieldPassword
import com.uagr.kmp.course.presentation.component.text.TextButtonCustom
import com.uagr.kmp.course.presentation.component.text.TextCustom
import com.uagr.kmp.course.presentation.feature.login.viewmodel.LoginUiState
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.il_finance
import course.shared.generated.resources.login_create_account
import course.shared.generated.resources.login_description
import course.shared.generated.resources.login_login
import course.shared.generated.resources.login_title
import course.shared.generated.resources.register_email
import course.shared.generated.resources.register_password
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun LoginContainer(
    state: LoginUiState,
    onEmailChange: (String) -> Unit = {},
    onPasswordChange: (String) -> Unit = {},
    onPasswordVisibleChange: (Boolean) -> Unit = {},
    onLoginClick: () -> Unit = {},
    onRegisterClick: () -> Unit = {}
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Dimens.padding24)
            .verticalScroll(state = scrollState),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(Dimens.height32))

        TextCustom(
            modifier = Modifier.fillMaxWidth(),
            color = AppTheme.colors.text.blueMedium,
            style = AppTheme.typography.bodyBigExtraBold,
            text = stringResource(Res.string.login_title),
            textAlign = TextAlign.Left
        )

        Spacer(modifier = Modifier.height(Dimens.height8))

        TextCustom(
            modifier = Modifier.fillMaxWidth(),
            color = AppTheme.colors.text.gray,
            style = AppTheme.typography.bodyNormal,
            text = stringResource(Res.string.login_description),
            textAlign = TextAlign.Left
        )

        Spacer(modifier = Modifier.height(Dimens.height28))

        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(Res.drawable.il_finance),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )

        Spacer(modifier = Modifier.height(Dimens.height32))

        // Email
        TextFieldCustom(
            value = state.email,
            onValueChange = onEmailChange,
            labelColor = AppTheme.colors.text.fieldLabel,
            label = stringResource(Res.string.register_email),
            placeholderColor = AppTheme.colors.text.placeholder,
            placeholder = stringResource(Res.string.register_email),
            leadingIcon = Icons.Filled.Email,
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next,
        )

        Spacer(modifier = Modifier.height(Dimens.height16))

        // Password
        TextFieldPassword(
            value = state.password,
            onEmailChange = onPasswordChange,
            isPasswordVisible = state.isPasswordVisible,
            onPasswordVisibleChange = onPasswordVisibleChange,
            labelColor = AppTheme.colors.text.fieldLabel,
            label = stringResource(Res.string.register_password),
            placeholderColor = AppTheme.colors.text.placeholder,
            placeholder = stringResource(Res.string.register_password),
            leadingIcon = Icons.Filled.Password,
            trailingIconActive = Icons.Filled.Visibility,
            trailingIconInActive = Icons.Filled.VisibilityOff,
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Next,
        )
        Spacer(modifier = Modifier.height(Dimens.height24))

        ButtonCustom(
            onClick = onLoginClick,
            modifier = Modifier.fillMaxWidth(),
            backgroundButton = AppTheme.colors.primary,
            textColor = AppTheme.colors.backgrounds.white,
            text = stringResource(Res.string.login_login),
        )

        Spacer(modifier = Modifier.height(Dimens.height16))

        TextButtonCustom(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = Dimens.padding8, bottom = Dimens.height16),
            color = AppTheme.colors.primary,
            text = stringResource(Res.string.login_create_account),
            textStyle = AppTheme.typography.bodySmallSemiBold,
            onClick = onRegisterClick
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginContainerPreview() {
    SafeScreenContainerTest {
        LoginContainer(
            state = LoginUiState()
        )
    }
}
