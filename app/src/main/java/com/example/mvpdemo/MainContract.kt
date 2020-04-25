package com.example.mvpdemo

import com.example.mvpdemo.base.BaseContractKt
import kotlinx.coroutines.Job

/**
 * 地址列表页
 * @author ssq
 */
class MainContract {
    interface View : BaseContractKt.BaseView {

        /**
         * 删除地址成功
         */
        fun deleteAddressSuccess(position: Int)
    }

    interface Presenter : BaseContractKt.BasePresenter<View> {

        /**
         * 删除地址
         * @param id 地址id
         * @param position 列表位置
         */
        fun deleteAddress(id: String, position: Int): Job
    }
}
