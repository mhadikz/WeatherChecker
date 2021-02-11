package com.mhadikz.weatherchecker.api

import com.mhadikz.weatherchecker.model.ForecastWeatherData
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("onecall")
    suspend fun getForecastWeatherData(@Query("lat") latitude: String,
                                       @Query("lon") longitude: String,
                                       @Query("exclude") exclude: String,
                                       @Query("appid") apiKey: String): ForecastWeatherData

}