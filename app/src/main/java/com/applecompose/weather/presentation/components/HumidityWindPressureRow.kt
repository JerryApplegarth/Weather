package com.applecompose.weather.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.applecompose.weather.R
import com.applecompose.weather.data.model.WeatherItem

@Composable
fun HumidityWindPressureRow(weather: WeatherItem) {
	Row(
		modifier = Modifier
			.padding(6.dp)
			.fillMaxWidth(),

		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.SpaceBetween
	) {
		Row(
			modifier = Modifier
				.padding(4.dp)
		) {
			Icon(
				painter = painterResource(id = R.drawable.humidity),
				contentDescription = "Humidity icon",
				modifier = Modifier
					.size(20.dp)
			)
			Text(text = " ${weather.main.humidity}%")
		}
		Row() {
			Icon(
				painter = painterResource(id = R.drawable.wind),
				contentDescription = "Wind icon",
				modifier = Modifier
					.size(20.dp)
			)
			Text(text = " ${weather.wind.speed.toInt()} mph")
		}
		Row() {
			Icon(
				painter = painterResource(id = R.drawable.ic_arrow_outward),
				contentDescription = "Wind direction icon",
				modifier = Modifier
					.size(20.dp)
			)
			Text(text = " ${weather.wind.deg} degree")
		}




	}

}

