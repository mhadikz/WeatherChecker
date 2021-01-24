package com.mhadikz.weatherchecker.view.fragment

import com.mhadikz.weatherchecker.R
import com.mhadikz.weatherchecker.databinding.TomorrowFragmentBinding
import com.mhadikz.weatherchecker.view.base.BaseFragment
import com.mhadikz.weatherchecker.view.viewModel.TomorrowViewModel

class TomorrowFragment : BaseFragment<TomorrowViewModel, TomorrowFragmentBinding>() {

    override fun setViewModelClass() = TomorrowViewModel::class.java

    override fun layoutId(): Int {
        return R.layout.tomorrow_fragment
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