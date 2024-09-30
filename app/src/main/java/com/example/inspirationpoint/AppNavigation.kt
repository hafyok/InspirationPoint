package com.example.inspirationpoint

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "message_screen") {
        composable("message_screen") {
            MessageScreen(modifier = modifier)
        }
        /*composable("main_screen") {
            val viewModel = remember { MainViewModel() }
            MainScreen(
                viewModel = viewModel,
                onNavigateToAnotherScreen = { cryptoId ->
                    navController.navigate("detail_screen/$cryptoId") // Передаем id валюты в маршрут
                }
            )
        }*/


    }
}