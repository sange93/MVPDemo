package com.example.mvpdemo.plugin

import android.widget.Toast
import com.example.mvpdemo.BaseApplication

/**
 * Toast工具类
 * @author ssq
 */
object ToastUtils {

    /**
     * 显示消息
     * @param msg 消息内容
     */
    fun showShort(msg: String){
        Toast.makeText(BaseApplication.instance, msg, Toast.LENGTH_SHORT).show()
    }
}