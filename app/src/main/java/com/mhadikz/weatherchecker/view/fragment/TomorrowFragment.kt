package com.mhadikz.weatherchecker.view.fragment

import androidx.lifecycle.ViewModelProvider
import com.mhadikz.weatherchecker.R
import com.mhadikz.weatherchecker.databinding.TomorrowFragmentBinding
import com.mhadikz.weatherchecker.view.base.BaseFragment
import com.mhadikz.weatherchecker.view.viewModel.TomorrowViewModel
import com.mhadikz.weatherchecker.view.viewModel.ViewModelFactory

class TomorrowFragment : BaseFragment<TomorrowViewModel, TomorrowFragmentBinding>() {

    override fun setViewModelClass(): Class<TomorrowViewModel> = TomorrowViewModel::class.java

    override fun layoutId(): Int {
        return R.layout.tomorrow_fragment
    }

    override fun initComponents() {
        // TODO: Implement the initComponents
    }

    override fun initObservers() {
        // TODO: Implement the initObservers
    }

    override fun setViewModelFactory(): ViewModelProvider.Factory {
        return ViewModelFactory()
    }
    override fun onBindComponentsValues() {
        // TODO: Implement the onBindComponentsValues
    }


}