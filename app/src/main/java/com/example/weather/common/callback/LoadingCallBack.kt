package com.example.weather.common.callback

import com.example.weather.R
import com.kingja.loadsir.callback.Callback

/**
 * @author: klaus
 * @date: 2020/10/26
 */
class LoadingCallBack : Callback() {
    override fun onCreateView() : Int=R.layout.layout_loading
}