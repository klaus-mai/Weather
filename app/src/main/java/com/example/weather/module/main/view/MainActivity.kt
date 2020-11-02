package com.example.weather.module.main.view

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.amap.api.location.AMapLocationClient
import com.amap.api.location.AMapLocationClientOption
import com.amap.api.location.AMapLocationListener
import com.amap.api.services.core.LatLonPoint
import com.amap.api.services.geocoder.GeocodeResult
import com.amap.api.services.geocoder.GeocodeSearch
import com.amap.api.services.geocoder.RegeocodeQuery
import com.amap.api.services.geocoder.RegeocodeResult
import com.example.weather.R
import com.example.weather.base.BaseApplication
import com.example.weather.base.view.BaseLifeCycleActivity
import com.example.weather.common.permission.PermissionResult
import com.example.weather.common.permission.Permissions
import com.example.weather.common.util.CommonUtil
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

    }


    override fun onGeocodeSearched(p0: GeocodeResult?, p1: Int) {

    }
    private fun initLocation(){
        locationClient= AMapLocationClient(BaseApplication.instance)
        locationOption=getDefaultOption()
        //设置定位参数
        locationClient!!.setLocationOption(locationOption)
        //设置定位参数
        locationClient!!.setLocationListener(locationListener)
        startLocation()
    }
    var locationListener =
        AMapLocationListener{ location->
            if (location!=null) {
                if (location.errorCode==0) {
                    regeocoder(location.latitude,location.longitude)
                } else {
                    CommonUtil.showToast(this,"定位失败")
                }
            }
        }
    private fun startLocation(){
        locationClient!!.setLocationOption(locationOption)
        locationClient!!.startLocation()
        CommonUtil.showToast(this,"正在定位中请稍后...")
    }

    private fun regeocoder(lat: Double, lng: Double) {
        val query = RegeocodeQuery(
                LatLonPoint(lat, lng), 200F,
                GeocodeSearch.AMAP
        )
        geocoderSearch!!.getFromLocationAsyn(query)
    }

    private fun getDefaultOption(): AMapLocationClientOption?{
        var mOption=AMapLocationClientOption()
        mOption.locationMode=
            AMapLocationClientOption.AMapLocationMode.Hight_Accuracy
        mOption.isGpsFirst=true
        mOption.httpTimeOut=30000
        mOption.interval = 2000
        mOption.isNeedAddress = true
        mOption.isOnceLocation = true
        mOption.isOnceLocationLatest = false
        AMapLocationClientOption.setLocationProtocol(AMapLocationClientOption.AMapLocationProtocol.HTTPS)
        mOption.isSensorEnable = false
        mOption.isWifiScan = true
        mOption.isLocationCacheEnable = true
        mOption.geoLanguage = AMapLocationClientOption.GeoLanguage.DEFAULT
        return mOption
    }
    private fun initPermission(){
        Permissions(this).request(*mPermissions).observe(
            this, Observer {
                when(it){
                    is PermissionResult.Grant ->{
                        initLocation()
                    }
                    //进入页面申请权限
                    is PermissionResult.Rationale ->{
                        var intent=Intent(
                            Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                        )
                        intent.data=Uri.parse("package:$packageName")
                        startActivity(intent)
                    }
                    is PermissionResult.Deny ->{
                        var intent=Intent(
                                Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                        )
                        intent.data=Uri.parse("package:$packageName")
                        startActivity(intent)
                    }
                }
          }
        )
    }
    private fun stopLocation(){
        //locationClient!!.setLocationOption(locationOption)
        locationClient!!.stopLocation()
    }
    //destroy Client
    private fun destroyLocation(){
        locationClient!!.onDestroy()
        locationClient==null
        locationOption==null
    }

    override fun onDestroy() {
        super.onDestroy()
        destroyLocation()
    }

}