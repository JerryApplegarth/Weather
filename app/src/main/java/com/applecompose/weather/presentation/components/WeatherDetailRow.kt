package com.applecompose.weather.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.applecompose.weather.data.model.WeatherItem
import com.applecompose.weather.presentation.utils.formatDate
import com.applecompose.weather.presentation.utils.formatDecimals

@Composable
fun WeatherDetailRow(weather: WeatherItem) {
	val imageUrl = "https://openweathermap.org/img/wn/${weather.weather[0].icon}.png"
	Surface(
		Modifier
			.padding(4.dp)
			.fillMaxWidth(),
		shape = RoundedCornerShape(16.dp),
		color = Color.White,
		elevation = 6.dp
	) {

		Row(
			modifier = Modifier
				.fillMaxWidth()
				.background(Color.White),
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.SpaceBetween
		) {

			Text(
				formatDate(weather.dt)
					.split(",")[0],
				modifier = Modifier.padding(start = 5.dp)
			)
			//val newDate = weather.dt_txt + 3
			Text(
				weather.dt_txt
					.split(":")[0],

				modifier = Modifier.padding(start = 5.dp)
			)

			WeatherStateImageSmall(imageUrl = imageUrl)
			Text(text = buildAnnotatedString {
				withStyle(
					style = SpanStyle(
						color = MaterialTheme.colors.primary.copy(alpha = 0.7f),
						fontWeight = FontWeight.SemiBold
					)
				) {
					append(formatDecimals(weather.main.temp_max) + "º")
				}
				withStyle(
					style = SpanStyle(
						color = MaterialTheme.colors.secondary
					)
				) {
					append(formatDecimals(weather.main.temp_min) + "º")
				}
			})

			Text(
				weather.weather[0].description,
				modifier = Modifier.padding(4.dp),
				style = MaterialTheme.typography.caption
			)

		}


	}

}

