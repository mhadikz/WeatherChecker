package com.mhadikz.weatherchecker.util

import kotlin.math.roundToInt

object TemperatureUtil {

    fun convertKelvinToCelsius(temp: Double) : Number{
        val convertNum = temp.minus(273.15)
        return convertNum.roundToInt()
    }

}