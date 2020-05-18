package com.congda.jianxin.ui.fragment.mvp.model

import com.congda.baselibrary.mvp.BaseModel
import com.congda.baselibrary.net.TypeOneBaseHttpResult
import com.congda.jianxin.bean.BannerBean
import com.congda.jianxin.net.repository.RetrofitUtils
import com.congda.jianxin.ui.fragment.mvp.contract.ListFirstContract
import io.reactivex.Observable

class ListFirstModel : BaseModel(), ListFirstContract.Model{

    override fun getBannList(): Observable<TypeOneBaseHttpResult<MutableList<BannerBean>>> {
        return RetrofitUtils.getHttpService().getBanner()
    }

}