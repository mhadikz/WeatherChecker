package com.mhadikz.weatherchecker.model

import com.google.gson.annotations.SerializedName


data class CityWeather (
    @SerializedName("coord")
    val location: Location,
    val weather: List<Weather>,
    val base: String,
    val main: Main,
    val visibility: Long,
    val wind: Wind,
    val clouds: Clouds,
    @SerializedName("dt")
    val date: Long,
    val sys: Sys,
    val timezone: Long,
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("cod")
    val code: Long
)

data class Clouds (
    val all: Long
)

data class Location (
    val lon: Double,
    val lat: Double
)

data class Main (
    val temp: Double,

    @SerializedName("feels_like")
    val feelsLike: Double,

    @SerializedName("temp_min")
    val tempMin: Double,

    @SerializedName("temp_max")
    val tempMax: Double,

    val pressure: Long,
    val humidity: Long
)

data class Sys (
    val type: Long,
    val id: Long,
    val country: String,
    val sunrise: Long,
    val sunset: Long
)

data class Weather (
    val id: Long,
    val main: String,
    val description: String,
    val icon: String
)

data class Wind (
    val speed: Double,
    val deg: Long
)
