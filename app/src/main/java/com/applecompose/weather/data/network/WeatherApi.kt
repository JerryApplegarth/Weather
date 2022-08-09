package com.applecompose.weather.data.network

import com.applecompose.weather.data.model.City
import com.applecompose.weather.data.model.Weather
import com.applecompose.weather.presentation.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherApi {
	@GET(value = "data/2.5/forecast?lat=43.23&lon=-123.32&appid=0591da9bc5afc7d4ba5f0232b164cb3f&units=imperial")
	suspend fun getWeather(
		@Query(value = "city") name: String = "Roseburg",
		@Query(value = "appid") appid: String = Constants.API_KEY

	): Weather
}

// https://api.openweathermap.org/data/2.5/forecast?lat=43.23&lon=-123.32

//const val BASE_URL = "https://api.openweathermap.org/"
//const val API_KEY = "&appid=0591da9bc5afc7d4ba5f0232b164cb3f&units=imperial"
//const val END_POINT = "data/2.5/forecast?lat=43.23&lon=-123.32"