package com.mhadikz.weatherchecker.di.module

import com.mhadikz.weatherchecker.api.ApiService
import com.mhadikz.weatherchecker.repository.OpenWeatherRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideOpenWeatherRepository(apiService: ApiService) : OpenWeatherRepository {
        return OpenWeatherRepository(apiService)
    }

}