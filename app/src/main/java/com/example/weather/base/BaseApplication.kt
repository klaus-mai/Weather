package com.example.weather.base

import android.app.Application
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner

/**
 * @author: klaus
 * @date: 2020/10/13
 */
open class BaseApplication : Application(),ViewModelStoreOwner{

    lateinit var mAppViewModelStore: ViewModelStore

    override fun getViewModelStore(): ViewModelStore {
        return mAppViewModelStore
    }




}