package com.example.weather.base.repository

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @author: klaus
 * @date: 2020/10/15
 */
open class BaseRepository{

    private val mCompositeDisposable by lazy { CompositeDisposable()}

    fun addSubscribe(disposable: Disposable)=mCompositeDisposable.add(disposable)

    fun unSubscribe()=mCompositeDisposable.dispose()

}