package com.applecompose.weather.domain.repository

import com.applecompose.weather.data.DataOrException
import com.applecompose.weather.data.model.Weather
import com.applecompose.weather.data.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(
	private val  api: WeatherApi
) {
	suspend fun getWeather(cityQuery: String): DataOrException<Weather, Boolean, Exception> {
		val response = try {
			api.getWeather()

		}catch (e: Exception) {
			return DataOrException(e = e)
		}
		return DataOrException(data = response)

	}

}