package com.mhadikz.weatherchecker.view.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.mhadikz.weatherchecker.repository.OpenWeatherRepository
import com.mhadikz.weatherchecker.util.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel (private val openWeatherRepository: OpenWeatherRepository) : ViewModel(){



    fun currentWeather(cityName: String, apiKey: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = openWeatherRepository.getCityWeather(cityName, apiKey)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, msg = exception.message ?: "Error Occurred!"))
        }
    }

}