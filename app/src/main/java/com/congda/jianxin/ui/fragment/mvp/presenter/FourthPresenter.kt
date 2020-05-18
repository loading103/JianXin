package com.congda.jianxin.ui.fragment.mvp.presenter

import com.congda.baselibrary.mvp.BasePresenter
import com.congda.jianxin.ui.fragment.mvp.contract.FourthContract
import com.congda.jianxin.ui.fragment.mvp.model.FourthModel

class FourthPresenter : BasePresenter<FourthContract.Model, FourthContract.View>(){

    override fun createModel(): FourthContract.Model {
        return FourthModel()
    }
}


