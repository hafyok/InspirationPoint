package com.example.inspirationpoint.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.inspirationpoint.presentation.DevicesScreen.DevicesScreen
import com.example.inspirationpoint.presentation.MessageScreen.MessageScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier, navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "messages_screen") {
        composable("home_screen") {  }
        composable("devs_screen") {
            DevicesScreen()
        }
        composable("apparatuses_screen") {  }
        composable("messages_screen") {
            MessageScreen(modifier = modifier)
        }
        composable("statistics_screen") {  }
        composable("settings_screen") {  }

    }
}