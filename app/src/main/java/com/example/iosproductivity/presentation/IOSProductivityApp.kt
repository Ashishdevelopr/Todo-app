package com.example.iosproductivity.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.iosproductivity.presentation.home.HomeScreen
import com.example.iosproductivity.presentation.theme.IOSProductivityTheme

@Composable
fun IOSProductivityApp() {
    IOSProductivityTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "login") {
            composable("login") {
                com.example.iosproductivity.presentation.auth.LoginScreen(
                    onLoginSuccess = {
                        navController.navigate("home") {
                            popUpTo("login") { inclusive = true }
                        }
                    }
                )
            }
            composable("home") { 
                HomeScreen() 
            }
        }
    }
}
