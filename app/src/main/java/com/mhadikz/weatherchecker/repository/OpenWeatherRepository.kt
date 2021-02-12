package com.mhadikz.weatherchecker.repository

import com.mhadikz.weatherchecker.api.ApiService
import com.mhadikz.weatherchecker.model.ForecastWeatherData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OpenWeatherRepository @Inject constructor(private val apiService: ApiService) {

    private var apiKey: String
    private var exclude: String

    init {
        exclude = "minutely"
        apiKey = ""
    }

    suspend fun getForecastWeatherData(latitude: String, longitude: String):
            ForecastWeatherData =
        apiService.getForecastWeatherData(
            latitude,
            longitude,
            exclude,
            apiKey
        )
}