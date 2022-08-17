package com.applecompose.weather.presentation.components

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.applecompose.weather.data.model.Weather
import com.applecompose.weather.navigation.screen.Screen
import com.applecompose.weather.presentation.screens.main.MainContent

@Composable
fun MainScaffold(
	weather: Weather,
	navController: NavController,
	isImperial: Boolean = true
) {
	Scaffold(topBar = {
		WeatherAppBar(
			title = weather.city.name,
			navController = navController,
			onAddActionClicked = {
				navController.navigate(Screen.SearchScreen.route)
			},
			elevation = 6.dp,
			)
	}) {
		MainContent(data = weather)

	}
}