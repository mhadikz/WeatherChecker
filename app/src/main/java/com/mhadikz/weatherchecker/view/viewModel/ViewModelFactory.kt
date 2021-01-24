package com.mhadikz.weatherchecker.view.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mhadikz.weatherchecker.api.ApiHelper
import com.mhadikz.weatherchecker.repository.OpenWeatherRepository

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(OpenWeatherRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}