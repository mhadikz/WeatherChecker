package com.mhadikz.weatherchecker.model

data class ForecastWeatherData(
    val lat : Double,
    val lon : Double,
    val timezone: String,
    val timezone_offset: Int,
    val current: Current,
    val hourly: List<Hourly>,
    val daily: List<Daily>
)





