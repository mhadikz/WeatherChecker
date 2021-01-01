package com.mhadikz.weatherchecker.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseFragment <V: ViewModel?, D: ViewDataBinding?> : Fragment() {

    open var viewModel: V? = null
    open var binding: D? = null


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        initComponents()
        setViewModelFactory()?.let { factory ->
            initViewModel(factory, setViewModelClass())
        }
        initBinding(inflater, container)
        return binding?.root
    }

    private fun initViewModel(factory: ViewModelProvider.Factory, viewModelClass: Class<V>) {
        viewModel = ViewModelProvider(this, factory).get(viewModelClass)
    }
    abstract fun setViewModelClass(): Class<V>

    private fun initBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DataBindingUtil.inflate<D>(inflater, layoutId(), container, false)
        onBindComponentsValues()
    }

    protected abstract fun layoutId(): Int
    protected abstract fun initComponents()
    protected abstract fun initObservers()
    protected abstract fun setViewModelFactory(): ViewModelProvider.Factory?
    protected abstract fun onBindComponentsValues()

}