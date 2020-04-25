package com.example.mvpdemo.plugin

import android.accounts.NetworkErrorException
import android.content.res.Resources
import com.example.mvpdemo.BaseApplication
import com.example.mvpdemo.R
import com.example.mvpdemo.net.NullBodyException
import com.google.gson.stream.MalformedJsonException
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * 异常工具类
 * @author ssq
 */
object ExceptionUtil {

    /**
     * 处理异常
     */
    fun catchException(e: Exception) {
        e.printStackTrace()
        val msg = when (e) {
            is HttpException -> {
                catchHttpException(e.code())
                return
            }
            is SocketTimeoutException -> R.string.common_error_net_time_out
            is UnknownHostException, is NetworkErrorException -> R.string.common_error_net
            is NullPointerException, is ClassCastException, is Resources.NotFoundException, is MalformedJsonException -> R.string.common_error_do_something_fail
            is NullBodyException -> R.string.common_error_server_body_null
            else -> R.string.common_error_do_something_fail
        }
        ToastUtils.showShort(BaseApplication.instance.getString(msg))
    }

    /**
     * 处理网络异常
     */
    fun catchHttpException(errorCode: Int) {
        if (errorCode in 200 until 300) return// 成功code则不处理
        val errorMsg = catchHttpExceptionCode(errorCode)
        ToastUtils.showShort("${BaseApplication.instance.getString(errorMsg)}：$errorCode ")
    }

    /**
     * 处理网络异常
     */
    private fun catchHttpExceptionCode(errorCode: Int): Int = when (errorCode) {
        in 500..600 -> R.string.common_error_server
        in 400 until 500 -> R.string.common_error_request
        else -> R.string.common_error_request
    }
}
