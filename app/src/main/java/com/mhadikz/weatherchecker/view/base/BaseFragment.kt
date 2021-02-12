package com.mhadikz.weatherchecker.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

abstract class BaseFragment <V: ViewModel, D: ViewDataBinding?> : Fragment() {

    @Inject lateinit var viewModel: V
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
        initComponents()
        initObservers()
        return binding?.root
    }

    abstract fun setViewModelClass(): Class<V>
    private fun initViewModel(factory: ViewModelProvider.Factory, viewModelClass: Class<V>) {
        viewModel = ViewModelProvider(this, factory).get(viewModelClass)
    }

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