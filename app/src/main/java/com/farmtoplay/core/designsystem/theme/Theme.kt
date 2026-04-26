package com.farmtoplay.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val FarmColorScheme = darkColorScheme(
    primary = LeafGreen,
    secondary = Hay,
    tertiary = Sunset,
    background = MossGreen,
    surface = FieldGreen,
    onPrimary = MossGreen,
    onSecondary = Soil,
    onTertiary = Cream,
    onBackground = Cream,
    onSurface = Cream
)

@Composable
fun FarmToPlayTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = FarmColorScheme,
        typography = FarmTypography,
        content = content
    )
}
