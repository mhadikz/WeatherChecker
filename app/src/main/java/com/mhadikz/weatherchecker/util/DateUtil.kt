package com.mhadikz.weatherchecker.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object DateUtil {

    fun getDateString(timeInSeconds: Long) : String{
        val timeInMilliSeconds = timeInSeconds * 1000
        val pattern = "E, dd MMM"
        val formatter = SimpleDateFormat(pattern, Locale.US)
        return formatter.format(timeInMilliSeconds)
    }

}