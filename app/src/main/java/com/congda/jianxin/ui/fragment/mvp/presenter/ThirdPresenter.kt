package com.congda.jianxin.ui.fragment.mvp.presenter

import com.congda.baselibrary.mvp.BasePresenter
import com.congda.jianxin.ui.fragment.mvp.contract.ThirdContract
import com.congda.jianxin.ui.fragment.mvp.model.ThirdModel

class ThirdPresenter : BasePresenter<ThirdContract.Model, ThirdContract.View>(){

    override fun createModel(): ThirdContract.Model {
        return ThirdModel()
    }
}


