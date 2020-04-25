package com.example.mvpdemo.base

import android.content.Context
import kotlinx.coroutines.CoroutineScope

/**
 * （Kotlin）界面MVP基类
 * @param scope 协程范围
 * @author ssq
 */
open class BasePresenterKt<T : BaseContractKt.BaseView>(scope: CoroutineScope) : BaseContractKt.BasePresenter<T>, CoroutineScope by scope {

    protected var mView: T? = null
    protected var mContext: Context? = null

    @Suppress("UNCHECKED_CAST")
    override fun <T1 : BaseContractKt.BaseView> attachView(view: T1) {
        mView = view as T
    }

    override fun detachView() {
        if (mView != null) {
            mView = null
        }
    }

    override fun initContext(context: Context) {
        mContext = context
    }
}