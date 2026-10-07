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
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
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
    // 4
    val bodyMicroExtra: TextStyle,
    val bodyMicroExtraSemiBold: TextStyle,
    val bodyMicroExtraBold: TextStyle,
    // 6
    val bodyMicro: TextStyle,
    val bodyMicroSemiBold: TextStyle,
    val bodyMicroBold: TextStyle,
    // 8
    val bodyTinyExtra: TextStyle,
    val bodyTinyExtraSemiBold: TextStyle,
    val bodyTinyExtraBold: TextStyle,
    // 10
    val bodyTiny: TextStyle,
    val bodyTinySemiBold: TextStyle,
    val bodyTinyBold: TextStyle,
    // 12
    val bodySmallExtra: TextStyle,
    val bodySmallExtraSemiBold: TextStyle,
    val bodySmallExtraBold: TextStyle,
    // 14
    val bodySmall: TextStyle,
    val bodySmallSemiBold: TextStyle,
    val bodySmallBold: TextStyle,
    // 15
    val bodyNormalExtra: TextStyle,
    val bodyNormalExtraSemiBold: TextStyle,
    val bodyNormalExtraBold: TextStyle,
    // 16
    val bodyNormal: TextStyle,
    val bodyNormalSemiBold: TextStyle,
    val bodyNormalBold: TextStyle,
    // 18
    val bodyMediumExtra: TextStyle,
    val bodyMediumExtraSemiBold: TextStyle,
    val bodyMediumExtraBold: TextStyle,

    // 20
    val bodyMedium: TextStyle,
    val bodyMediumSemiBold: TextStyle,
    val bodyMediumBold: TextStyle,
    // 24
    val bodyBig: TextStyle,
    val bodyBigSemiBold: TextStyle,
    val bodyBigBold: TextStyle,
    // 25
    val bodyBigExtraMicro: TextStyle,
    val bodyBigExtraMicroSemiBold: TextStyle,
    val bodyBigExtraMicroBold: TextStyle,
    // 32
    val bodyBigExtra: TextStyle,
    val bodyBigExtraSemiBold: TextStyle,
    val bodyBigExtraBold: TextStyle,
    // 34
    val bodyBigExtraLarge: TextStyle,
    val bodyBigExtraLargeSemiBold: TextStyle,
    val bodyBigExtraLargeBold: TextStyle,
    // 40
    val bodyLarge: TextStyle,
    val bodyLargeSemiBold: TextStyle,
    val bodyLargeBold: TextStyle,
)

val appTypography
    @Composable get() = AppTypography(
        bodyMicroExtra = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeExtraMicro, fontWeight = FontWeight.Normal),
        bodyMicroExtraSemiBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeExtraMicro, fontWeight = FontWeight.SemiBold),
        bodyMicroExtraBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeExtraMicro, fontWeight = FontWeight.Bold),

        bodyMicro = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeMicro, fontWeight = FontWeight.Normal),
        bodyMicroSemiBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeMicro, fontWeight = FontWeight.SemiBold),
        bodyMicroBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeMicro, fontWeight = FontWeight.Bold),

        bodyTinyExtra = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeExtraTiny, fontWeight = FontWeight.Normal),
        bodyTinyExtraSemiBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeExtraTiny, fontWeight = FontWeight.SemiBold),
        bodyTinyExtraBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeExtraTiny, fontWeight = FontWeight.Bold),

        bodyTiny = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeTiny, fontWeight = FontWeight.Normal),
        bodyTinySemiBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeTiny, fontWeight = FontWeight.SemiBold),
        bodyTinyBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeTiny, fontWeight = FontWeight.Bold),

        bodySmallExtra = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeExtraSmall, fontWeight = FontWeight.Normal),
        bodySmallExtraSemiBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeExtraSmall, fontWeight = FontWeight.SemiBold),
        bodySmallExtraBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeExtraSmall, fontWeight = FontWeight.Bold),

        bodyNormalExtra = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeExtraNormal, fontWeight = FontWeight.Normal),
        bodyNormalExtraSemiBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeExtraNormal, fontWeight = FontWeight.SemiBold),
        bodyNormalExtraBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeExtraNormal, fontWeight = FontWeight.Bold),

        bodySmall = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeSmall, fontWeight = FontWeight.Normal),
        bodySmallSemiBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeSmall, fontWeight = FontWeight.SemiBold),
        bodySmallBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeSmall, fontWeight = FontWeight.Bold),

        bodyNormal = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeNormal, fontWeight = FontWeight.Normal),
        bodyNormalSemiBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeNormal, fontWeight = FontWeight.SemiBold),
        bodyNormalBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeNormal, fontWeight = FontWeight.Bold),

        bodyMediumExtra = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeMediumExtra, fontWeight = FontWeight.Normal),
        bodyMediumExtraSemiBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeMediumExtra, fontWeight = FontWeight.SemiBold),
        bodyMediumExtraBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeMediumExtra, fontWeight = FontWeight.Bold),

        bodyMedium = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeMedium, fontWeight = FontWeight.Normal),
        bodyMediumSemiBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeMedium, fontWeight = FontWeight.SemiBold),
        bodyMediumBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeMedium, fontWeight = FontWeight.Bold),

        bodyBig = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeBig, fontWeight = FontWeight.Medium),
        bodyBigSemiBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeBig, fontWeight = FontWeight.SemiBold),
        bodyBigBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeBig, fontWeight = FontWeight.Bold),

        bodyBigExtraMicro = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeBigExtraMicro, fontWeight = FontWeight.Medium),
        bodyBigExtraMicroSemiBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeBigExtraMicro, fontWeight = FontWeight.SemiBold),
        bodyBigExtraMicroBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeBigExtraMicro, fontWeight = FontWeight.Bold),

        bodyBigExtra = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeBigExtra, fontWeight = FontWeight.Medium),
        bodyBigExtraSemiBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeBigExtra, fontWeight = FontWeight.SemiBold),
        bodyBigExtraBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeBigExtra, fontWeight = FontWeight.Bold),

        bodyBigExtraLarge = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeBigExtraLarge, fontWeight = FontWeight.Medium),
        bodyBigExtraLargeSemiBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeBigExtraLarge, fontWeight = FontWeight.SemiBold),
        bodyBigExtraLargeBold = TextStyle(fontFamily = fontFamily, fontSize = Dimens.textSizeBigExtraLarge, fontWeight = FontWeight.Bold),

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
