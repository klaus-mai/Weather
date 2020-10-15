package com.example.weather.base.view

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import com.example.weather.base.viewmodel.BaseViewModel

/**
 * @author: klaus
 * @date: 2020/10/15
 */
abstract class BaseActivity<VM: BaseViewModel<*>, DB :ViewDataBinding> : AppCompatActivity(){
    private lateinit var mViewModel:VM
    private lateinit var mDataBinding: DB

    open fun initView(){}

    open fun initData(){}

    open fun reload(){}

    abstract fun getLayoutId():Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}