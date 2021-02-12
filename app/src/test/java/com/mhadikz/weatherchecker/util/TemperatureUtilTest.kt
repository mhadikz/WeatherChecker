package com.mhadikz.weatherchecker.util

import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TemperatureUtilTest{

    @Test
    fun convert(){
        val temp = TemperatureUtil.convertKelvinToCelsius(281.15)
        assertEquals(8, temp)
    }

}