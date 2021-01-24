package com.mhadikz.weatherchecker.api

import com.mhadikz.weatherchecker.model.CityWeather
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("weather")
    suspend fun getCityWeather(@Query("q") cityName: String, @Query("appid") apiKey: String): CityWeather

}