package com.example.youtubeproject.core.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity <VB : ViewBinding, VM : BaseViewModel> : AppCompatActivity () {

    protected lateinit var binding: VB
    protected abstract fun inflateViewBinding(): VB
    protected abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateViewBinding()
        setContentView(binding.root)

        checkInternet()
        setUI ()
        setupLiveData()
        initClick ()


    }

    private fun initClick() {} // обработка кликов

    private fun setupLiveData() {} // инициализация LiveData

    private fun setUI() {} //

    private fun checkInternet() {}

}