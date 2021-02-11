package com.mhadikz.weatherchecker.view.base

import androidx.lifecycle.ViewModel
import com.mhadikz.weatherchecker.di.component.ApplicationComponent
import com.mhadikz.weatherchecker.di.component.DaggerApplicationComponent
import com.mhadikz.weatherchecker.di.module.NetworkModule
import com.mhadikz.weatherchecker.di.module.RepositoryModule
import com.mhadikz.weatherchecker.view.viewModel.MainViewModel

abstract class BaseViewModel : ViewModel(){
    private val injector: ApplicationComponent = DaggerApplicationComponent
        .builder()
        .networkModule(NetworkModule())
        .repositoryModule(RepositoryModule())
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is MainViewModel -> injector.inject(this)
        }
    }
}