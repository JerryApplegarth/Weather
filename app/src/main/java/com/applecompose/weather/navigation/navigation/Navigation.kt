package com.applecompose.weather.navigation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.applecompose.weather.navigation.screen.Screen
import com.applecompose.weather.presentation.screens.about.AboutScreen
import com.applecompose.weather.presentation.screens.favorities.FavoritesScreen
import com.applecompose.weather.presentation.screens.main.MainScreen
import com.applecompose.weather.presentation.screens.main.MainViewModel
import com.applecompose.weather.presentation.screens.search.SearchScreen
import com.applecompose.weather.presentation.screens.settings.SettingsScreen
import com.applecompose.weather.presentation.screens.splash.SplashScreen

@Composable
fun Navigation() {
	val navController = rememberNavController()
	NavHost(
		navController = navController,
		startDestination = Screen.SplashScreen.route) {

		composable(Screen.SplashScreen.route) {
			SplashScreen(navController = navController)
		}

		composable(Screen.MainScreen.route) {
			val mainViewModel = hiltViewModel<MainViewModel>()
			MainScreen(navController = navController, mainViewModel)
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