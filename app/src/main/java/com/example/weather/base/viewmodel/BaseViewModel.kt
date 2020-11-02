package com.example.weather.base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather.base.repository.BaseRepository
import com.example.weather.common.state.State
import com.example.weather.common.util.CommonUtil

/**
 * @author: klaus
 * @date: 2020/10/15
 */
open class BaseViewModel<T: BaseRepository> : ViewModel(){
    val loadState by lazy {
        MutableLiveData<State>()
    }
    val mRepository:T by lazy {
        (CommonUtil.getClass<T>(this))
                .getDeclaredConstructor(MutableLiveData::class.java)
                .newInstance(loadState)
    }

    override fun onCleared() {
        super.onCleared()
        mRepository.unSubscribe()
    }
}