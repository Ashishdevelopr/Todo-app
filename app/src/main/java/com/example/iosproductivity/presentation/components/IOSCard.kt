package com.example.iosproductivity.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.iosproductivity.presentation.theme.IOSWhite

@Composable
fun IOSCard(
    modifier: Modifier = Modifier,
    backgroundColor: Color = IOSWhite,
    cornerRadius: Dp = 16.dp,
    elevation: Dp = 4.dp, // Soft shadow
    content: @Composable ColumnScope.() -> Unit
) {
    Surface(
        modifier = modifier
            .shadow(
                elevation = elevation,
                shape = RoundedCornerShape(cornerRadius),
                ambientColor = Color.Black.copy(alpha = 0.05f),
                spotColor = Color.Black.copy(alpha = 0.05f)
            ),
        shape = RoundedCornerShape(cornerRadius),
        color = backgroundColor,
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            content()
        }
    }
}
