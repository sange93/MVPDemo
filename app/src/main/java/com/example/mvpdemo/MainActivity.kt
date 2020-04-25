package com.example.mvpdemo

import com.example.mvpdemo.base.BaseActivityKt

/**
 * 主页面(MVP架构示例)
 * @author ssq
 */
class MainActivity : BaseActivityKt<MainPresenter>(), MainContract.View {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initInjector() {
        mPresenter = MainPresenter(this)
    }

    override fun initView() {
//        TODO("初始化界面")
        val dataId = "123456"// 数据ID
        val listPosition = 0// 在列表中的下标位置
        mPresenter?.deleteAddress(dataId, listPosition)
    }

    override fun deleteAddressSuccess(position: Int) {
//        TODO("Not yet implemented")
    }

    /**
     * 展示错误信息
     */
    override fun showFail(message: String?) {
//        TODO("Not yet implemented")
    }
}
