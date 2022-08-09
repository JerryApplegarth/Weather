package com.applecompose.weather.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun WeatherStateImage(imageUrl: String) {
	Image(
		painter = rememberImagePainter(imageUrl),
		contentDescription = "image icon",
		modifier = Modifier
			.size(100.dp)
	)
}