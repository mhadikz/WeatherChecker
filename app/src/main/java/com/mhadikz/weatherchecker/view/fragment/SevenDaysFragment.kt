package com.mhadikz.weatherchecker.view.fragment

import com.mhadikz.weatherchecker.R
import com.mhadikz.weatherchecker.databinding.SevenDaysFragmentBinding
import com.mhadikz.weatherchecker.view.base.BaseFragment
import com.mhadikz.weatherchecker.view.viewModel.SevenDaysViewModel

class SevenDaysFragment : BaseFragment<SevenDaysViewModel, SevenDaysFragmentBinding>() {

    override fun setViewModelClass() = SevenDaysViewModel::class.java

    override fun layoutId(): Int {
        return R.layout.seven_days_fragment
    }

    override fun initComponents() {
        // TODO: Implement the initComponents
    }

    override fun initObservers() {
        // TODO: Implement the initObservers
    }

    override fun setViewModelFactory(): Nothing? = null

    override fun onBindComponentsValues() {
        // TODO: Implement the onBindComponentsValues
    }


}