package com.applecompose.weather.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.applecompose.weather.data.DataOrException
import com.applecompose.weather.data.model.Weather
import com.applecompose.weather.data.model.WeatherItem
import com.applecompose.weather.presentation.components.HumidityWindPressureRow
import com.applecompose.weather.presentation.components.MainScaffold
import com.applecompose.weather.presentation.components.WeatherDetailRow
import com.applecompose.weather.presentation.components.WeatherStateImage
import com.applecompose.weather.presentation.utils.formatDate
import com.applecompose.weather.presentation.utils.formatDecimals

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
fun MainContent(data: Weather) {
	val weatherItem = data.list[0]
	val imageUrl = "https://openweathermap.org/img/wn/${data.list[0].weather[0].icon}.png"

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
				Text(text = "Weather App ${data.city.name}")
				Text(text = formatDate(weatherItem.dt))
			}
			Spacer(modifier = Modifier.height(20.dp))
			Row(
				modifier = Modifier
					.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceEvenly
			) {
				Text(
					text = formatDecimals(weatherItem.main.temp) + "°",
					style = MaterialTheme.typography.h3,
					fontWeight = FontWeight.ExtraBold,
					fontFamily = FontFamily.Monospace,
					modifier = Modifier
						.padding(top = 16.dp)
				)
				WeatherStateImage(imageUrl = imageUrl)
			}
			Row(
				modifier = Modifier
					.fillMaxWidth(),
				horizontalArrangement = Arrangement.Center
			) {
				Text(text = weatherItem.weather[0].description)
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
					Text(text = "Feels Like:${formatDecimals(weatherItem.main.feels_like)}" + "°")
					Text(
						text = "" +
								"Hi ${formatDecimals(weatherItem.main.temp_max)}" + "° | " +
								"Lo ${formatDecimals(weatherItem.main.temp_min)}" + "°"
					)
				}
			}
			Spacer(modifier = Modifier.height(12.dp))
			HumidityWindPressureRow(weather = weatherItem)
			Divider(
				color = MaterialTheme.colors.secondary,
				thickness = 2.dp
			)
			Text(
				text = "Hourly Forecast Every 4 Hours",
				style = MaterialTheme.typography.subtitle1,
				fontWeight = FontWeight.Bold,
				modifier = Modifier
					.align(Alignment.CenterHorizontally)
			)
			Surface(
				modifier = Modifier
					.fillMaxWidth()
					.fillMaxHeight()
					.padding(12.dp)
					.background(MaterialTheme.colors.primary),
				shape = RoundedCornerShape(6.dp)
			) {
				LazyColumn(
					modifier = Modifier
						.padding(2.dp)
						.background(MaterialTheme.colors.primary),
					contentPadding = PaddingValues(1.dp)
				) {

					items(items = data.list) { item: WeatherItem ->

						WeatherDetailRow(weather = item)
					}
				}
			}
		}
	}
}



