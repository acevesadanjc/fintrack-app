/*
 * Type.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import course.shared.generated.resources.Res
import course.shared.generated.resources.open_sans
import org.jetbrains.compose.resources.Font

val fontFamily
    @Composable get() = FontFamily(
        Font(resource = Res.font.open_sans, weight = FontWeight.Normal),
        Font(resource = Res.font.open_sans, weight = FontWeight.Bold),
    )

val MaterialThemAppTypography
    @Composable
    get() = Typography(
        headlineLarge = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = Dimens.textSizeBig,
        ),
        titleLarge = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = Dimens.textSizeBig,
        ),
        bodyLarge = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = Dimens.textSizeBig,
        ),
        labelLarge = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = Dimens.textSizeBig,
        ),
        headlineMedium = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = Dimens.textSizeMedium,
        ),
        titleMedium = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = Dimens.textSizeMedium,
        ),
        bodyMedium = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = Dimens.textSizeMedium,
        ),
        labelMedium = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = Dimens.textSizeMedium,
        ),
        headlineSmall = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = Dimens.textSizeSmall,
        ),
        titleSmall = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = Dimens.textSizeSmall,
        ),
        bodySmall = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = Dimens.textSizeSmall,
        ),
        labelSmall = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = Dimens.textSizeSmall,
        ),
    )

@Immutable
data class AppTypography(
    val bodySmallExtra: TextStyle,
    val bodySmallExtraSemiBold: TextStyle,
    val bodySmallExtraBold: TextStyle,
    val bodySmall: TextStyle,
    val bodySmallSemiBold: TextStyle,
    val bodySmallBold: TextStyle,
    val bodyNormal: TextStyle,
    val bodyNormalSemiBold: TextStyle,
    val bodyNormalBold: TextStyle,
    val bodyMedium: TextStyle,
    val bodyMediumSemiBold: TextStyle,
    val bodyMediumBold: TextStyle,
    val bodyBig: TextStyle,
    val bodyBigSemiBold: TextStyle,
    val bodyBigBold: TextStyle,
    val bodyBigExtra: TextStyle,
    val bodyBigExtraSemiBold: TextStyle,
    val bodyBigExtraBold: TextStyle,
    val bodyLarge: TextStyle,
    val bodyLargeSemiBold: TextStyle,
    val bodyLargeBold: TextStyle,
)

val appTypography
    @Composable get() = AppTypography(
        bodySmallExtra = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeExtraSmall, fontWeight = FontWeight.Normal),
        bodySmallExtraSemiBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeExtraSmall, fontWeight = FontWeight.SemiBold),
        bodySmallExtraBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeExtraSmall, fontWeight = FontWeight.Bold),

        bodySmall = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeSmall, fontWeight = FontWeight.Normal),
        bodySmallSemiBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeSmall, fontWeight = FontWeight.SemiBold),
        bodySmallBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeSmall, fontWeight = FontWeight.Bold),

        bodyNormal = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeNormal, fontWeight = FontWeight.Normal),
        bodyNormalSemiBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeNormal, fontWeight = FontWeight.SemiBold),
        bodyNormalBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeNormal, fontWeight = FontWeight.Bold),

        bodyMedium = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeMedium, fontWeight = FontWeight.Normal),
        bodyMediumSemiBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeMedium, fontWeight = FontWeight.SemiBold),
        bodyMediumBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeMedium, fontWeight = FontWeight.Bold),

        bodyBig = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeBig, fontWeight = FontWeight.Medium),
        bodyBigSemiBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeBig, fontWeight = FontWeight.SemiBold),
        bodyBigBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeBig, fontWeight = FontWeight.Bold),

        bodyBigExtra = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeBigExtra, fontWeight = FontWeight.Medium),
        bodyBigExtraSemiBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeBigExtra, fontWeight = FontWeight.SemiBold),
        bodyBigExtraBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeBigExtra, fontWeight = FontWeight.Bold),

        bodyLarge = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeLarge, fontWeight = FontWeight.Medium),
        bodyLargeSemiBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeLarge, fontWeight = FontWeight.SemiBold),
        bodyLargeBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeLarge, fontWeight = FontWeight.Bold)
)

@Immutable
data class AppSpanStyle(
    val bodyLarge: SpanStyle,
)

val appSpanStyle @Composable get() =
    AppSpanStyle(bodyLarge = SpanStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeBig))
