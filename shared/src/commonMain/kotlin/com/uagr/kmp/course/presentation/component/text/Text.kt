package com.uagr.kmp.course.presentation.component.text

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import com.uagr.kmp.course.presentation.component.container.SafeScreenContainerTest
import com.uagr.kmp.course.presentation.theme.AppTheme
import com.uagr.kmp.course.presentation.theme.Dimens
import course.shared.generated.resources.Res
import course.shared.generated.resources.example
import org.jetbrains.compose.resources.stringResource

/**
 * Standardized typography system for the application.
 *
 * Usage guide:
 *
 * - `bodySmallExtra` (12px)
 * - `bodySmall` (14px):
 * - `bodyNormal` (16px)
 * - `bodyMedium` (20px)
 * - `bodyBig` (24px)
 * - `bodyBigExtra` (32px)
 * - `bodyLargeBold` (40px)
 *
 */
@Composable
fun TextCustom(
    modifier: Modifier = Modifier,
    style: TextStyle = AppTheme.typography.bodyNormal,
    color: Color,
    text: String,
    textAlign: TextAlign = TextAlign.Center,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = style,
        color = color,
    )
}

@Composable
fun TextUrlLink(
    modifier: Modifier = Modifier,
    fontSize: TextUnit = Dimens.textSizeNormal,
    textColor: Color,
    linkColor: Color,
    text: String,
    linkText: String,
    url: String,
    textAlign: TextAlign = TextAlign.Center,
) {
    Text(
        modifier = modifier,
        text = buildAnnotatedString {
            pushStyle(
                SpanStyle(
                    fontSize = fontSize,
                    fontWeight = FontWeight.Normal,
                    color = textColor,
                )
            )
            append(text)
            withLink(
                LinkAnnotation.Url(
                    url = url,
                    styles = TextLinkStyles(
                        style = SpanStyle(
                            fontSize = fontSize,
                            fontWeight = FontWeight.Bold,
                            color = linkColor,
                        ),
                    ),
                )
            ) {
                append(linkText)
            }
        },
        style = AppTheme.typography.bodyNormal.copy(
            fontSize = fontSize,
            fontWeight = FontWeight.Normal,
            textAlign = textAlign,
        ),
    )
}

@Composable
fun TextButtonCustom(
    modifier: Modifier,
    color: Color = AppTheme.colors.primary,
    text: String,
    textStyle: TextStyle,
    textAlign: TextAlign = TextAlign.Center,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = modifier.clickable(
                onClick = onClick
            ),
            text = text,
            color = color,
            style = textStyle,
            textAlign = textAlign,
        )
    }
}

@Preview(
    showBackground = true,
)
@Composable
private fun TextPreview() {
    SafeScreenContainerTest {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = Dimens.padding16),
            verticalArrangement = Arrangement.spacedBy(Dimens.padding16),
        ) {

            TextCustom(
                color = AppTheme.colors.text.blueMedium,
                style = AppTheme.typography.bodyBigExtraBold,
                text = stringResource(Res.string.example),
            )

            TextUrlLink(
                textColor = AppTheme.colors.backgrounds.black,
                linkColor = AppTheme.colors.backgrounds.blue,
                text = stringResource(Res.string.example),
                linkText = stringResource(Res.string.example),
                url = stringResource(Res.string.example),
            )

            TextButtonCustom(
                modifier = Modifier,
                text = stringResource(Res.string.example),
                textStyle = AppTheme.typography.bodyNormal
            )
        }
    }
}
