package com.mhadikz.weatherchecker.view.fragment

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.mhadikz.weatherchecker.R
import com.mhadikz.weatherchecker.databinding.TodayFragmentBinding
import com.mhadikz.weatherchecker.view.base.BaseFragment
import com.mhadikz.weatherchecker.view.viewModel.MainViewModel
import com.mhadikz.weatherchecker.view.viewModel.TodayViewModel
import com.mhadikz.weatherchecker.view.viewModel.ViewModelFactory

class TodayFragment : BaseFragment<TodayViewModel, TodayFragmentBinding>() {

    override fun setViewModelClass(): Class<TodayViewModel> = TodayViewModel::class.java


    override fun layoutId(): Int {
        return R.layout.today_fragment
    }

    override fun initComponents() {
    }

    override fun initObservers() {
    }

    override fun onBindComponentsValues() {
        // TODO: Implement the onBindComponentsValues
    }

    override fun setViewModelFactory(): ViewModelProvider.Factory {
        return ViewModelFactory()
    }

}