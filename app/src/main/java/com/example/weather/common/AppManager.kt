package com.example.weather.common

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*
import kotlin.system.exitProcess

/**
 * @author: klaus
 * @date: 2020/10/12
 */
class AppManager{
    //新建一个栈去存储Activity
    private val activitySatck:Stack<Activity> = Stack()

    companion object {
        val instance by lazy {
            AppManager()
        }
    }

    fun addActivity(activity: Activity){
        activitySatck.add(activity)
    }

    fun removeActivity(activity: Activity){
        activitySatck.remove(activity)
    }

    fun exitApp(context:Context){
        finishActivity()
        val activityManager=context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.killBackgroundProcesses(context.packageName)
        exitProcess(0)
    }

    private fun finishActivity(){
        for (activity in activitySatck){
            activity.finish()
        }
        activitySatck.clear()
    }
}