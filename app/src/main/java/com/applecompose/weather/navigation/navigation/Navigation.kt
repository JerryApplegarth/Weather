package com.applecompose.weather.navigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.applecompose.weather.navigation.screen.Screen
import com.applecompose.weather.presentation.screens.about.AboutScreen
import com.applecompose.weather.presentation.screens.favorities.FavoritesScreen
import com.applecompose.weather.presentation.screens.main.MainScreen
import com.applecompose.weather.presentation.screens.search.SearchScreen
import com.applecompose.weather.presentation.screens.settings.SettingsScreen

@Composable
fun Navigation() {
	val navController = rememberNavController()
	NavHost(
		navController = navController,
		startDestination = Screen.MainScreen.route) {

		composable(Screen.MainScreen.route) {
			MainScreen(navController = navController)
		}
		composable(Screen.SearchScreen.route) {
			SearchScreen(navController = navController)
		}
		composable(Screen.AboutScreen.route) {
			AboutScreen(navController = navController)
		}
		composable(Screen.FavoritesScreen.route) {
			FavoritesScreen(navController = navController)
		}
		composable(Screen.SettingsScreen.route) {
			SettingsScreen(navController = navController)
		}
	}


}