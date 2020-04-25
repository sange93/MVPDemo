package com.example.mvpdemo.base

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

/**
 *  （Kotlin）界面基类（如不需要MVP 可继承此类）
 *  "CoroutineScope by MainScope()" 协程生命周期管理。在onDestroy()中调用cancel()取消协程。调用launch{}启动协程
 *  如想在页面销毁时不取消协程，请使用GlobalScope.launch{}启动协程
 *  @author ssq
 */
@SuppressLint("Registered")
abstract class BaseActivityKt<T : BaseContractKt.BasePresenter<*>> : AppCompatActivity(), CoroutineScope by MainScope(), BaseContractKt.BaseView {
    protected var mPresenter: T? = null

    /**
     * 获取页面布局xml文件 id
     */
    protected abstract fun getLayoutId(): Int

    /**
     * 初始化注入
     * 如：mPresenter初始化
     */
    protected abstract fun initInjector()

    /**
     * 初始化界面
     */
    protected abstract fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initInjector()
        mPresenter?.attachView(this)
        mPresenter?.initContext(this)
        initView()
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        // 过度绘制优化：去掉window的默认背景
        window.setBackgroundDrawable(null)
    }

    override fun onDestroy() {
        cancel()// 取消协程
        super.onDestroy()
    }
}