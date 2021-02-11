package com.mhadikz.weatherchecker.view.viewModel

import androidx.lifecycle.liveData
import com.mhadikz.weatherchecker.repository.OpenWeatherRepository
import com.mhadikz.weatherchecker.util.Resource
import com.mhadikz.weatherchecker.view.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class MainViewModel @Inject constructor () : BaseViewModel(){


    @Inject
    lateinit var repository: OpenWeatherRepository

    fun currentWeather(latitude: String, longitude: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getForecastWeatherData(latitude, longitude)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, msg = exception.message ?: "Error Occurred!"))
        }
    }

}