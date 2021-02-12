package com.mhadikz.weatherchecker.util

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertSame
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class DateUtilTest{

    @Mock
    lateinit var date: Calendar

    @Before
    fun setUp(){
        date = Calendar.getInstance()
        date.timeInMillis = 1611425745
    }

    @Test
    fun convertSecondsToDate_CorrectFormat_Today(){
        val date = DateUtil.getDateString(1611425745)
        assertEquals("Sat, 23 Jan", date)
    }

}