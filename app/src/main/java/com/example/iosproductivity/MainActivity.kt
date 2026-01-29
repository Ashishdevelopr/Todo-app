package com.example.iosproductivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.iosproductivity.presentation.IOSProductivityApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IOSProductivityApp()
        }
    }
}
