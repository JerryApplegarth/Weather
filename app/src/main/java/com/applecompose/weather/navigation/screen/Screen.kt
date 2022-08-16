package com.applecompose.weather.navigation.screen

sealed class Screen(val route: String) {

	object AboutScreen: Screen("about_screen")
	object FavoritesScreen: Screen("favorites_screen")
	object MainScreen: Screen("main_screen")
	object SearchScreen: Screen("search_screen")
	object SettingsScreen: Screen("settings_screen")
	object SplashScreen: Screen("splash_screen")
}

