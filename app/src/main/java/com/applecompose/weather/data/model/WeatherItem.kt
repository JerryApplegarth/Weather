package com.applecompose.weather.data.model

data class WeatherItem(
	val clouds: Clouds,
	val dt: Int,
	val dt_txt: String,
	val main: Main,
	val pop: Int,
	val sys: Sys,
	val visibility: Int,
	val weather: List<WeatherObject>,
	val wind: Wind
)
