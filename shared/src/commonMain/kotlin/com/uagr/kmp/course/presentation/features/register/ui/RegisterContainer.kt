/*
 * RegisterContainer.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.features.register.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Adjust
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Airplay
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.uagr.kmp.course.presentation.component.buton.ButtonCustom
import com.uagr.kmp.course.presentation.component.buton.IconButtonCustom
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.component.field.TextFieldCustom
import com.uagr.kmp.course.presentation.component.field.TextFieldPassword
import com.uagr.kmp.course.presentation.component.text.TextCustom
import com.uagr.kmp.course.presentation.features.register.viewmodel.RegisterUiState
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.ic_back_arrow
import course.shared.generated.resources.register_confirm_password
import course.shared.generated.resources.register_description
import course.shared.generated.resources.register_email
import course.shared.generated.resources.register_name
import course.shared.generated.resources.register_password
import course.shared.generated.resources.register_register_user
import course.shared.generated.resources.register_title
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource


@Composable
fun RegisterContainer(
    state: RegisterUiState,
    onNameChange: (String) -> Unit = {},
    onEmailChange: (String) -> Unit = {},
    onPasswordChange: (String) -> Unit = {},
    onPasswordVisibleChange: (Boolean) -> Unit = {},
    onConfirmPasswordChange: (String) -> Unit = {},
    onConfirmPasswordVisibleChange: (Boolean) -> Unit = {},
    onRegisterClick: () -> Unit = {},
    onNavigateBackClick: () -> Unit = {},
) {

    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Dimens.padding16)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        Spacer(modifier = Modifier.height(Dimens.height16))

        IconButtonCustom(
            modifier = Modifier.size(Dimens.height20),
            tint = AppTheme.colors.backgrounds.black,
            icon = painterResource(Res.drawable.ic_back_arrow),
            onClick = onNavigateBackClick
        )

        Spacer(modifier = Modifier.height(Dimens.height16))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = Dimens.padding16),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ) {

        TextCustom(
            modifier = Modifier.fillMaxWidth(),
            style = AppTheme.typography.bodyBigExtraBold,
            color = AppTheme.colors.text.blueMedium,
            text = stringResource(Res.string.register_title),
            textAlign = TextAlign.Left
        )

        Spacer(modifier = Modifier.height(Dimens.height8))

        TextCustom(
            modifier = Modifier.fillMaxWidth(),
            color = AppTheme.colors.text.gray,
            style = AppTheme.typography.bodyNormal,
            text = stringResource(Res.string.register_description),
            textAlign = TextAlign.Left
        )

        Spacer(modifier = Modifier.height(Dimens.height32))

        // Name
        TextFieldCustom(
            value = state.name,
            onValueChange = onNameChange,
            labelColor = AppTheme.colors.text.fieldLabel,
            label = stringResource(Res.string.register_name),
            placeholderColor = AppTheme.colors.text.placeholder,
            placeholder = stringResource(Res.string.register_name),
            leadingIcon = Icons.Filled.Person,
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next,
        )

        Spacer(modifier = Modifier.height(Dimens.height16))

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

        Spacer(modifier = Modifier.height(Dimens.height16))

        // Confirm Password
        TextFieldPassword(
            value = state.confirmPassword,
            onEmailChange = onConfirmPasswordChange,
            isPasswordVisible = state.isConfirmPasswordVisible,
            onPasswordVisibleChange = onConfirmPasswordVisibleChange,
            labelColor = AppTheme.colors.text.fieldLabel,
            label = stringResource(Res.string.register_confirm_password),
            placeholderColor = AppTheme.colors.text.placeholder,
            placeholder = stringResource(Res.string.register_confirm_password),
            leadingIcon = Icons.Filled.Password,
            trailingIconActive = Icons.Filled.Visibility,
            trailingIconInActive = Icons.Filled.VisibilityOff,
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done,
            keyboardActions = KeyboardActions(
                onAny = {
                    focusManager.clearFocus()
                },
            ),
        )
    }

        ButtonCustom(
            onClick = { onRegisterClick() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Dimens.padding64),
            backgroundButton = AppTheme.colors.primary,
            textColor = AppTheme.colors.text.white,
            text = stringResource(Res.string.register_register_user),
            textAlign = TextAlign.Left
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun RegisterContainerPreview() {
    SafeScreenContainerTest {
        RegisterContainer(
            state = RegisterUiState(),
        )
    }
}
