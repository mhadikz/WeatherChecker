package com.mhadikz.weatherchecker.repository

import com.mhadikz.weatherchecker.api.ApiHelper

class OpenWeatherRepository (private val apiHelper: ApiHelper){

    suspend fun getCityWeather(cityName: String, apiKey: String) = apiHelper.getCityWeather(cityName, apiKey)

}