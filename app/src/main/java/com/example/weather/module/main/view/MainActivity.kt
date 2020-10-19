package com.example.weather.module.main.view

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil.setContentView
import com.amap.api.location.AMapLocationClient
import com.amap.api.location.AMapLocationClientOption
import com.amap.api.services.geocoder.GeocodeResult
import com.amap.api.services.geocoder.GeocodeSearch
import com.amap.api.services.geocoder.RegeocodeResult
import com.example.weather.R
import com.example.weather.base.view.BaseLifeCycleActivity
import com.example.weather.databinding.ActivityMainBinding
import com.example.weather.model.Place
import com.example.weather.module.main.viewModel.MainViewModel

class MainActivity : BaseLifeCycleActivity<MainViewModel, ActivityMainBinding>(),
    GeocodeSearch.OnGeocodeSearchListener {
    private var locationClient: AMapLocationClient? = null
    private var locationOption: AMapLocationClientOption? = null
    private var geocoderSearch: GeocodeSearch? = null
    private var mPlace: Place? = null
    private val mPermissions = arrayOf(
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.INTERNET,
        Manifest.permission.ACCESS_NETWORK_STATE,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.READ_PHONE_STATE
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun getLayoutId() = R.layout.activity_main

    override fun onRegeocodeSearched(p0: RegeocodeResult?, p1: Int) {
        TODO("Not yet implemented")
    }


    override fun onGeocodeSearched(p0: GeocodeResult?, p1: Int) {
        TODO("Not yet implemented")
    }
    private fun initLocation(){

    }

}