package com.mhadikz.weatherchecker.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseActivity<V: ViewModel?,
        D: ViewDataBinding?> : AppCompatActivity() {

    open var viewModel: V? = null
    open var binding: D? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setViewModelFactory()?.let { factory ->
            initViewModel(factory, setViewModelClass())
        }
        initBinding()
        initComponents()
    }

    abstract fun setViewModelClass(): Class<V>
    private fun initViewModel(factory: ViewModelProvider.Factory, vmClass: Class<V>) {
        viewModel = ViewModelProvider(this, factory).get(vmClass)
    }
    private fun initBinding() {
        binding = DataBindingUtil.setContentView<D>(this, layoutId())
        onBindComponentsValues()
    }

    protected abstract fun layoutId(): Int
    protected abstract fun initComponents()
    protected abstract fun initObservers()
    protected abstract fun setViewModelFactory(): ViewModelProvider.Factory?
    protected abstract fun onBindComponentsValues()
}