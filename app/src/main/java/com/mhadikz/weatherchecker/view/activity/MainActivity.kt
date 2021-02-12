package com.mhadikz.weatherchecker.view.activity

import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.mhadikz.weatherchecker.R
import com.mhadikz.weatherchecker.adapter.ForecastDaysAdapter
import com.mhadikz.weatherchecker.databinding.ActivityMainBinding
import com.mhadikz.weatherchecker.model.ForecastWeatherData
import com.mhadikz.weatherchecker.util.DateUtil
import com.mhadikz.weatherchecker.util.Status
import com.mhadikz.weatherchecker.util.TemperatureUtil
import com.mhadikz.weatherchecker.view.base.BaseActivity
import com.mhadikz.weatherchecker.view.viewModel.ViewModelFactory
import com.mhadikz.weatherchecker.view.fragment.SevenDaysFragment
import com.mhadikz.weatherchecker.view.fragment.TodayFragment
import com.mhadikz.weatherchecker.view.fragment.TomorrowFragment
import com.mhadikz.weatherchecker.view.viewModel.MainViewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {


    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun initComponents() {
        initPageAdapter()
    }

    override fun setViewModelClass(): Class<MainViewModel> = MainViewModel::class.java

    override fun initObservers() {
        viewModel.getForecastWeather("31.3203", "48.6693").observe(this, {
            it?.let { resource ->
                when (resource.status) {
                    Status.START -> {
                    }
                    Status.SUCCESS -> {
                        resource.data?.let { data ->
                            setValues(data)
                            binding?.loading?.visibility = View.GONE
                            binding?.mainLayout?.visibility = View.VISIBLE
                        }

                    }
                    Status.ERROR -> {
                        binding?.loading?.visibility = View.GONE
                        binding?.error?.visibility = View.VISIBLE
                    }
                    Status.LOADING -> {
                    }
                    Status.EMPTY -> {
                        binding?.loading?.visibility = View.GONE
                        binding?.error?.visibility = View.VISIBLE
                    }
                }
            }
        })
    }


    override fun setViewModelFactory(): ViewModelProvider.Factory {
        return ViewModelFactory()
    }

    override fun onBindComponentsValues() {

    }

    private fun initPageAdapter() {
        val adapter = ForecastDaysAdapter(supportFragmentManager)
        adapter.addFragment(TodayFragment(), getString(R.string.today))
        adapter.addFragment(TomorrowFragment(), getString(R.string.tomorrow))
        adapter.addFragment(SevenDaysFragment(), getString(R.string.seven_days))
        binding?.viewPager?.adapter = adapter
        binding?.tabLayout?.setupWithViewPager(binding?.viewPager)
    }

    private fun setValues(forecastWeatherData: ForecastWeatherData) {
        binding?.forecastWeatherData = forecastWeatherData
        binding?.txtCityName?.text = forecastWeatherData.timezone
        binding?.txtTemperatureNumber?.text =
            TemperatureUtil.convertKelvinToCelsius(forecastWeatherData.current.temp).toString()
        binding?.txtDate?.text = DateUtil.getDateString(forecastWeatherData.current.dt)
    }

}