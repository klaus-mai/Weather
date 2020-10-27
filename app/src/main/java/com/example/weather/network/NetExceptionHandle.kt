package com.example.weather.network

import androidx.lifecycle.MutableLiveData
import com.example.weather.common.state.State

/**
 * @author: klaus
 * @date: 2020/10/27
 */
object NetExceptionHandle{
    fun handleException (e:Throwable,lateState:MutableLiveData<State>){
        e?.let {
            when(it){

            }
        }
    }
}