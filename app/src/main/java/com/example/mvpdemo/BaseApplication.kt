package com.example.mvpdemo

import android.content.pm.ApplicationInfo
import androidx.multidex.MultiDexApplication

/**
 * 基础Application
 * @author ssq
 */
class BaseApplication : MultiDexApplication() {
    companion object {
        // app实例
        lateinit var instance: BaseApplication
        // 是否为debug模式
        var isDebugMode: Boolean = false
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        // 获取是否debug版本
        isDebugMode = instance.applicationInfo != null && instance.applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0
    }
}