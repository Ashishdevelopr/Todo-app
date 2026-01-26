package com.example.iosproductivity.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IOSLargeTitle(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = MaterialTheme.typography.displayLarge.copy(
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold
        ),
        modifier = modifier.padding(horizontal = 20.dp, vertical = 8.dp)
    )
}
