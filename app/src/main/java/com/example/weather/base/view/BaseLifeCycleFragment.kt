package com.example.weather.base.view

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.example.weather.base.viewmodel.BaseViewModel
import com.example.weather.common.callback.EmptyCallBack
import com.example.weather.common.callback.ErrorCallBack
import com.example.weather.common.callback.LoadingCallBack
import com.example.weather.common.state.State
import com.example.weather.common.state.StateType
import com.kingja.loadsir.callback.SuccessCallback
import java.util.*

/**
 * @author: klaus
 * @date: 2020/10/23
 */
abstract class BaseLifeCycleFragment <VM : BaseViewModel<*>, DB : ViewDataBinding>
    : BaseFragment<VM,DB>() {


    open fun initDataObserver(){}

    open fun showLoading(){
        loadService.showCallback(LoadingCallBack ::class.java)
    }

    open fun showSuccess(){
        loadService.showCallback(SuccessCallback ::class.java)
    }

    open fun showError(msg: String){
        if (!TextUtils.isEmpty(msg)){
            Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
        }
        loadService.showCallback(ErrorCallBack ::class.java)
    }

    open fun showEmpty(){
        loadService.showCallback(EmptyCallBack ::class.java)
    }

    private val observer by lazy {
        Observer<State> {
            it?.let {
                when(it.code) {
                    StateType.EMPTY -> showEmpty()
                    StateType.ERROR -> showError("网络异常")
                    StateType.LOADING -> showLoading()
                    StateType.NETWORK_ERROR -> showError("网络异常")
                    StateType.SUCCESS -> showSuccess()
                }
            }
        }
    }

    override fun reload() {
        showLoading()
        initData()
        initDataObserver()
        super.reload()
    }
}