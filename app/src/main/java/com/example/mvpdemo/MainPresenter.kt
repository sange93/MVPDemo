package com.example.mvpdemo

import com.example.mvpdemo.base.BasePresenterKt
import com.example.mvpdemo.net.RetrofitManagerKt
import com.example.mvpdemo.plugin.ToastUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * 地址列表页
 * @author ssq
 */
class MainPresenter(scope: CoroutineScope) : BasePresenterKt<MainContract.View>(scope),
    MainContract.Presenter {

    /**
     * 删除地址
     * @param id 地址id
     * @param position 列表位置
     */
    override fun deleteAddress(id: String, position: Int) = launch {
        val map = HashMap<String, Any>()
        map["id"] = id
        RetrofitManagerKt.request(RetrofitManagerKt.apiService.requestAsync(map), true, mContext)
            ?.also {
                if (it.code == 0) {// 成功
                    mView?.deleteAddressSuccess(position)
                } else {
                    ToastUtils.showShort(it.message)
                }
            } ?: mView?.showFail()
    }
}