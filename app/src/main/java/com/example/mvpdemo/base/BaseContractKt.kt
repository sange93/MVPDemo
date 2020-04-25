package com.example.mvpdemo.base

import android.content.Context

/**
 * （Kotlin）界面MVP基类
 * @author ssq
 */
interface BaseContractKt {
    interface BasePresenter<T : BaseView> {

        fun <T : BaseView> attachView(view: T)

        fun detachView()

        fun initContext(context: Context)
    }

    interface BaseView {

        /**
         * 展示错误信息
         */
        fun showFail(message: String? = null)
    }
}
