package com.example.weather.common.state

import androidx.annotation.StringRes

/**
 * @author: klaus
 * @date: 2020/10/15
 */
data class State(var code:StateType,var message:String="",@StringRes var tip:Int=0)