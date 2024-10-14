package com.example.bai3_8_1.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Màu sắc cho Light Mode
private val LightColors = lightColors(
    primary = Color(0xFF6200EE),
    primaryVariant = Color(0xFF3700B3),
    secondary = Color(0xFF03DAC6)
)

// Màu sắc cho Dark Mode
private val DarkColors = darkColors(
    primary = Color(0xFFBB86FC),
    primaryVariant = Color(0xFF3700B3),
    secondary = Color(0xFF03DAC6),
    background = Color(0xFF121212),
    surface = Color(0xFF121212),
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White
)

// Định nghĩa Typography (có thể tùy chỉnh theo ý bạn)
private val AppTypography = Typography()

// Định nghĩa Shapes (có thể tùy chỉnh theo ý bạn)
private val AppShapes = Shapes()

@Composable
fun MyAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), // Tự động chọn dựa trên hệ thống
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColors
    } else {
        LightColors
    }

    MaterialTheme(
        colors = colors,
        typography = AppTypography, // Sử dụng Typography của Material Design
        shapes = AppShapes, // Sử dụng Shapes của Material Design
        content = content
    )
}
