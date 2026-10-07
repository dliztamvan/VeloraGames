package com.velora.games.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val VeloraColors = lightColorScheme(
    primary = VeloraPurple,
    onPrimary = Color.White,
    secondary = VeloraPurpleDark,
    onSecondary = Color.White,
    background = VeloraBackground,
    onBackground = VeloraText,
    surface = VeloraSurface,
    onSurface = VeloraText,
    error = VeloraDanger,
    onError = Color.White
)

@Composable
fun VeloraTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = VeloraColors,
        content = content
    )
}
