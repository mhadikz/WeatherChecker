package com.mhadikz.weatherchecker.view.fragment

import com.mhadikz.weatherchecker.R
import com.mhadikz.weatherchecker.databinding.TodayFragmentBinding

class TodayFragment : BaseFragment<TodayViewModel, TodayFragmentBinding>() {

    override fun setViewModelClass() = TodayViewModel::class.java


    override fun layoutId(): Int {
        return R.layout.today_fragment
    }

    override fun initComponents() {
        // TODO: Implement the initComponents
    }

    override fun initObservers() {
        // TODO: Implement the initObservers
    }

    override fun onBindComponentsValues() {
        // TODO: Implement the onBindComponentsValues
    }

    override fun setViewModelFactory(): Nothing? = null


}