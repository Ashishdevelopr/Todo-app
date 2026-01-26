package com.example.iosproductivity.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.iosproductivity.presentation.theme.IOSBlack

// Using Default Sans Serif as a fallback for SF Pro
// In a real app, you would load the SF Pro font files here.
val IOSFontFamily = FontFamily.SansSerif

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = IOSFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp,
        color = IOSBlack
    ),
    displayMedium = TextStyle(
        fontFamily = IOSFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        color = IOSBlack
    ),
    titleLarge = TextStyle(
        fontFamily = IOSFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        color = IOSBlack
    ),
    titleMedium = TextStyle(
        fontFamily = IOSFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 17.sp, // Standard iOS body/headline
        color = IOSBlack
    ),
    bodyLarge = TextStyle(
        fontFamily = IOSFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        color = IOSBlack
    ),
    bodyMedium = TextStyle(
        fontFamily = IOSFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        color = IOSBlack
    ),
    labelMedium = TextStyle(
        fontFamily = IOSFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 13.sp,
        color = IOSGrayText
    )
)
