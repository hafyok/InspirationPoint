package com.example.inspirationpoint.presentation.navigation

sealed class BottomItem(val title: String, val route: String) {
    object Home : BottomItem("Home", "home_screen")
    object Devs : BottomItem("Devs", "devs_screen")
    object Apparatuses : BottomItem("Apparatuses", "apparatuses_screen")
    object Messages : BottomItem("Messages", "messages_screen")
    object Statistics : BottomItem("Statistics", "statistics_screen")
    object Settings : BottomItem("Settings", "settings_screen")
}