package com.example.weather.module.main.repository

import androidx.lifecycle.MutableLiveData
import com.example.weather.base.repository.ApiRepository
import com.example.weather.common.state.State

/**
 * @author: klaus
 * @date: 2020/10/15
 */
class MainRepository(val loadState: MutableLiveData<State>) : ApiRepository(){

}