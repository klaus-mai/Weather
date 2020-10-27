package com.example.weather.module.home.repository

import androidx.lifecycle.MutableLiveData
import com.example.weather.base.repository.ApiRepository
import com.example.weather.common.state.State

/**
 * @author: klaus
 * @date: 2020/10/24
 */
class HomeRepository(var loadState: MutableLiveData<State>) : ApiRepository(){

}