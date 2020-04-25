package com.example.mvpdemo.plugin

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * 验证服务器返回的code
 * 如果登录过期，就跳登录页
 */
suspend fun validateCode(context: Context?, code: Int) = withContext(Dispatchers.Main) {
    //TODO 这里你可以根据接口返回的错误代码，做相应的逻辑处理

    // 4041 用户被禁用（后台管理控制的）
//    if (code == 4041) {
//        cleanLoginInfo()
//    }
}