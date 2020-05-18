package com.congda.jianxin.ui.activity.mvp.presenter

import SplashAdBean
import com.congda.baselibrary.mvp.BasePresenter
import com.congda.baselibrary.net.BaseHttpResult
import com.congda.baselibrary.net.BaseObserver
import com.congda.baselibrary.rx.RxSchedulers
import com.congda.jianxin.ui.activity.mvp.contract.SplashContract
import com.congda.jianxin.ui.activity.mvp.model.SplashModel
import com.trello.rxlifecycle2.android.ActivityEvent

class SplashPresenter : BasePresenter<SplashContract.Model, SplashContract.View>() {

    override fun createModel(): SplashContract.Model {
        return SplashModel()
    }

    fun getSplashData() {
        model.getGetAdJson()
            .compose(RxSchedulers.applySchedulers(getLifecycleProvider<ActivityEvent>()))
            .subscribe(object : BaseObserver<List<SplashAdBean>>(view,false) {
                override fun onFailure(code: String, errMsg: String, isNetError: Boolean) {
                    view.showToast(errMsg)
                    view.setSplashData(null)
                }

                override fun onSuccess(result: BaseHttpResult<List<SplashAdBean>>) {
                    view.setSplashData(result)
                }

            })
    }
}


