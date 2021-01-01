package com.mhadikz.weatherchecker.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.mhadikz.weatherchecker.R
import com.mhadikz.weatherchecker.adapter.DateWeatherRcAdapter
import com.mhadikz.weatherchecker.adapter.ForecastDaysAdapter
import com.mhadikz.weatherchecker.adapter.GenericAdapter
import com.mhadikz.weatherchecker.databinding.ActivityMainBinding
import com.mhadikz.weatherchecker.databinding.TodayFragmentBinding
import com.mhadikz.weatherchecker.model.DateWeather
import com.mhadikz.weatherchecker.view.fragment.SevenDaysFragment
import com.mhadikz.weatherchecker.view.fragment.TodayFragment
import com.mhadikz.weatherchecker.view.fragment.TomorrowFragment

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {


    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun initComponents() {
        initPageAdapter()
    }

    override fun setViewModelClass(): Class<MainViewModel> = MainViewModel::class.java

    override fun initObservers() {
        // TODO: Implement the initObservers
    }

    override fun setViewModelFactory(): Nothing? = null


    override fun onBindComponentsValues() {
        // TODO: Implement the onBindComponentsValues
    }

    private fun initPageAdapter(){
        val adapter = ForecastDaysAdapter(supportFragmentManager)
        adapter.addFragment(TodayFragment(), getString(R.string.today))
        adapter.addFragment(TomorrowFragment(), getString(R.string.tomorrow))
        adapter.addFragment(SevenDaysFragment(), getString(R.string.seven_days))
        binding?.viewPager?.adapter = adapter
        binding?.tabLayout?.setupWithViewPager(binding?.viewPager)
    }
}