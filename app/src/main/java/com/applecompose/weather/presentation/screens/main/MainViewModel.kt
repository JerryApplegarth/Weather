package com.applecompose.weather.presentation.screens.main

import androidx.lifecycle.ViewModel
import com.applecompose.weather.data.DataOrException
import com.applecompose.weather.data.model.Weather
import com.applecompose.weather.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
	private val repository: WeatherRepository

): ViewModel() {

	suspend fun getWeatherData(city: String): DataOrException<Weather, Boolean, Exception> {
		return repository.getWeather(cityQuery = city)
	}




}