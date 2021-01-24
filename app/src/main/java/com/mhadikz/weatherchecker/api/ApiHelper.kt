package com.mhadikz.weatherchecker.api

import com.mhadikz.weatherchecker.model.CityWeather

class ApiHelper (private val apiService: ApiService) {

    suspend fun getCityWeather(cityName: String, apiKey: String): CityWeather{
        return apiService.getCityWeather(cityName, apiKey)
    }

}