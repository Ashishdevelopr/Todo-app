package com.example.iosproductivity.presentation.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
fun IOSProductivityTheme(
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            // Status bar same as background for clean look
            window.statusBarColor = IOSBackground.toArgb() 
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = true
        }
    }

    MaterialTheme(
        colorScheme = MaterialTheme.colorScheme.copy(
            background = IOSBackground,
            surface = IOSWhite,
            primary = IOSBlue,
            onBackground = IOSBlack,
            onSurface = IOSBlack
        ),
        typography = Typography,
        content = content
    )
}
