package com.applecompose.weather.presentation.screens.main

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.applecompose.weather.data.DataOrException
import com.applecompose.weather.data.model.Weather
import com.applecompose.weather.presentation.components.WeatherAppBar

@Composable
fun MainScreen(
	navController: NavController,
	mainViewModel: MainViewModel = hiltViewModel()) {

	val weatherData = produceState<DataOrException<Weather, Boolean, Exception>>(
		initialValue = DataOrException(loading = true)) {
		value = mainViewModel.getWeatherData(city = "Roseburg")
	}.value

	if (weatherData.loading == true) {
		CircularProgressIndicator()
	}else if (weatherData.data != null) {
		MainScaffold(weather = weatherData.data!!, navController)
	}





}

@Composable
fun MainScaffold(weather: Weather,
                 navController: NavController) {
	val context = LocalContext.current

	Scaffold(topBar = {
		WeatherAppBar(
			title = weather.city.name,
			navController = NavController(context),
			elevation = 6.dp
			)
	}) {
		MainContent(data = weather)

	}




}

@Composable
fun MainContent(data: Weather) {
	Text(text = data.city.name)


}
