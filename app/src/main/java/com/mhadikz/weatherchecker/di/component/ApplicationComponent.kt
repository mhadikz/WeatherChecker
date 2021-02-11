package com.mhadikz.weatherchecker.di.component

import com.mhadikz.weatherchecker.di.module.AppModule
import com.mhadikz.weatherchecker.di.module.NetworkModule
import com.mhadikz.weatherchecker.di.module.RepositoryModule
import com.mhadikz.weatherchecker.repository.OpenWeatherRepository
import com.mhadikz.weatherchecker.view.activity.MainActivity
import com.mhadikz.weatherchecker.view.viewModel.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, RepositoryModule::class])
interface ApplicationComponent {

    fun inject(appModule: AppModule)

    fun inject(mainViewModel: MainViewModel)

    fun inject(openWeatherRepository: OpenWeatherRepository)
}