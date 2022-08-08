package com.applecompose.weather.data.model


class WeatherItem(
	val clouds: Clouds,
	val dt: Int,
	val dt_txt: String,
	val main: Main,
	val pop: Double,
	val sys: Sys,
	val visibility: Int,
	val weather: List<WeatherObject>,
	val wind: Wind
)