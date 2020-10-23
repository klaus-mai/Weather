package com.example.weather.base.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.weather.base.viewmodel.BaseViewModel
import com.example.weather.common.util.CommonUtil
import com.kingja.loadsir.core.LoadService

/**
 * @author: klaus
 * @date: 2020/10/23
 */
abstract class BaseFragment<VM: BaseViewModel<*>, DB : ViewDataBinding> : Fragment(){
    protected lateinit var mViewModel : VM

    protected lateinit var mViewDataBinding: DB

    protected lateinit var loadService: LoadService<*>


    open fun initView(){}

    open fun initData(){}

    open fun reload()=initData()

    abstract fun getLayoutId():Int


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mViewModel=ViewModelProvider(this).get(CommonUtil.getClass(this))
        initData()
        initView()
        initStatusBarColor()
    }

    private fun initStatusBarColor(){

    }
}