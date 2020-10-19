package com.example.weather.base.repository

import com.example.weather.network.ApiService
import com.example.weather.network.RetrofitFactory

/**
 * @author: klaus
 * @date: 2020/10/15
 */
abstract class ApiRepository:BaseRepository(){
    private val apiService:ApiService by lazy {
        RetrofitFactory.instance.createRetrofit(ApiService::class.java)
    }
}