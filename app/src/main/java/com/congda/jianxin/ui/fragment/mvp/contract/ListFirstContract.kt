package com.congda.jianxin.ui.fragment.mvp.contract

import com.congda.baselibrary.mvp.IModel
import com.congda.baselibrary.mvp.IView
import com.congda.baselibrary.net.TypeOneBaseHttpResult
import com.congda.jianxin.bean.BannerBean
import io.reactivex.Observable

interface ListFirstContract {
    interface View : IView{
        fun hanedBannerData(baseHttpResult: TypeOneBaseHttpResult<MutableList<BannerBean>>)
        fun hanedListData(bean:MutableList<String>)
    }

    interface Model : IModel{
        fun  getBannList(): Observable<TypeOneBaseHttpResult<MutableList<BannerBean>>>
    }
}