package com.hnrylvo.movies.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val darkColorScheme = AppColorScheme(
    background = DarkBackground,
    onBackground = TextPrimary,
    primary = DarkPrimary,
    onPrimary = TextPrimary,
    secondary = DarkSecondary,
    onSecondary = TextPrimary
)

private val lightColorScheme = AppColorScheme(
    background = LightBackground,
    onBackground = DarkBackground,
    primary = LightPrimary,
    onPrimary = TextPrimary,
    secondary = LightSecondary,
    onSecondary = TextPrimary
)

private val typography = AppTypography(
    titleLarge = TextStyle(
        fontFamily = Poppings,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleNormal = TextStyle(
        fontFamily = Poppings,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    body = TextStyle(
        fontFamily = Poppings,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    labelLarge = TextStyle(
        fontFamily = Poppings,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelNormal = TextStyle(
        fontFamily = Poppings,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.4.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Poppings,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.3.sp
    )
)

private val shape = AppShape(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(8.dp),
    large = RoundedCornerShape(15.dp),
)

private val size = AppSize(
    large = 24.dp,
    medium = 16.dp,
    normal = 12.dp,
    small = 8.dp,
)

@Composable
fun AppTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (isDarkTheme) darkColorScheme else lightColorScheme
    CompositionLocalProvider(
        LocalAppColorScheme provides colorScheme,
        LocalAppTypography provides typography,
        LocalAppShape provides shape,
        LocalAppSize provides size,
        content = content
    )
}

object AppTheme {
    val colorScheme: AppColorScheme
        @Composable get() = LocalAppColorScheme.current
    val typography: AppTypography
        @Composable get() = LocalAppTypography.current
    val shape: AppShape
        @Composable get() = LocalAppShape.current
    val size: AppSize
        @Composable get() = LocalAppSize.current
}