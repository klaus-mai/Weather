package com.example.weather.network

import androidx.lifecycle.MutableLiveData
import com.example.weather.common.state.State
import com.example.weather.common.state.StateType
import com.google.gson.JsonParseException
import org.apache.http.conn.ConnectTimeoutException
import retrofit2.HttpException
import java.net.ConnectException
import java.net.UnknownHostException

/**
 * @author: klaus
 * @date: 2020/10/27
 */
object NetExceptionHandle{
    fun handleException (e:Throwable,loadState:MutableLiveData<State>){
        e?.let {
            when(it){
                is HttpException->{
                    loadState.postValue(State(StateType.NETWORK_ERROR))
                }
                is ConnectException->{
                    loadState.postValue(State(StateType.NETWORK_ERROR))
                }
                is ConnectTimeoutException -> {
                    loadState.postValue(State(StateType.NETWORK_ERROR))
                }
                is UnknownHostException -> {
                    loadState.postValue(State(StateType.NETWORK_ERROR))
                }
                is JsonParseException -> {
                    loadState.postValue(State(StateType.NETWORK_ERROR))
                }
                is NoClassDefFoundError -> {
                    loadState.postValue(State(StateType.NETWORK_ERROR))
                }
            }
        }
    }
}