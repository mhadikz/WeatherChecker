package com.mhadikz.weatherchecker.repository

import com.mhadikz.weatherchecker.api.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OpenWeatherRepository @Inject constructor(private val apiService : ApiService){

    suspend fun getCityWeather(cityName: String, apiKey: String) =
        apiService.getCityWeather(cityName, apiKey)

}