package com.example.weather.common.permission

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * @author: klaus
 * @date: 2020/10/16
 */
internal class PermissionFragment:Fragment(){
    lateinit var liveData : MutableLiveData<PermissionResult>

    private val PERMISSION_REQUEST_CODE=100

    //不中断保存
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance=true
    }
    //请求方法
    fun requestPermissions(permissions: Array<out String>){
        liveData= MutableLiveData()
        requestPermissions(permissions,PERMISSION_REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(
        requestCode:Int,
        permissions: Array<out String>,
        grantResults:IntArray
    ){
        if (requestCode==PERMISSION_REQUEST_CODE) {
            val denyPermission=ArrayList<String>()
            val rationalePermission=ArrayList<String>()

        }
    }
}