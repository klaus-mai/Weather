package com.example.weather.base.view

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.example.weather.base.viewmodel.BaseViewModel

/**
 * @author: klaus
 * @date: 2020/10/15
 */
abstract class BaseLifeCycleActivity<VM : BaseViewModel<*>, DB : ViewDataBinding>:
    BaseActivity<VM,DB>(){

}