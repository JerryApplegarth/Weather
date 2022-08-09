package com.applecompose.weather.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.applecompose.weather.data.DataOrException
import com.applecompose.weather.data.model.Weather
import com.applecompose.weather.presentation.components.WeatherAppBar

@Composable
fun MainScreen(
	navController: NavController,
	mainViewModel: MainViewModel = hiltViewModel(),
) {
	Surface(
		modifier = Modifier.fillMaxSize(),
		color = MaterialTheme.colors.primary
	) {

		val weatherData = produceState<DataOrException<Weather, Boolean, Exception>>(
			initialValue = DataOrException(loading = true)
		) {
			value = mainViewModel.getWeatherData(city = "Roseburg")
		}.value

		if (weatherData.loading == true) {
			CircularProgressIndicator()
		} else if (weatherData.data != null) {
			MainScaffold(weather = weatherData.data!!, navController)
		}
	}
}

@Composable
fun MainScaffold(
	weather: Weather,
	navController: NavController
) {
	val context = LocalContext.current

	Scaffold(topBar = {
		WeatherAppBar(
			title = weather.city.name,
			navController = NavController(context),
			elevation = 6.dp,

			)
	}) {
		MainContent(data = weather)

	}


}

@Composable
fun MainContent(data: Weather) {
	Surface(
		modifier = Modifier
			.fillMaxSize(),
		color = MaterialTheme.colors.primary
	) {
		Column(
			modifier = Modifier
				.fillMaxWidth(),
			verticalArrangement = Arrangement.Top,
			horizontalAlignment = Alignment.Start
		) {
			Row(
				modifier = Modifier
					.fillMaxWidth()
					.padding(start = 12.dp, end = 12.dp),
				horizontalArrangement = Arrangement.SpaceBetween
			) {
				Text(text = "Weather App")
				Text(text = "Nov 29")
			}
			Spacer(modifier = Modifier.height(20.dp))

			Row(
				modifier = Modifier
					.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceEvenly
			) {
				Text(
					text = "66",
					fontSize = 48.sp
				)
				Text(
					text = "picture",
					fontSize = 48.sp
					)

			}
			Column(
				modifier = Modifier
					.fillMaxWidth()
					.padding(start = 12.dp)
			) {
				Spacer(modifier = Modifier.height(12.dp))
				Row(
					modifier = Modifier
						.fillMaxWidth()
						.padding(start = 12.dp, end = 12.dp),
				horizontalArrangement = Arrangement.SpaceBetween
				) {
					Text(text = "feels like")
					Text(text = "Hi 85 | Lo 60")
				}


			}
			Divider(
				color = MaterialTheme.colors.secondary,
				thickness = 2.dp
			)





		}
	}


}
