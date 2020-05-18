package com.congda.jianxin.ui.fragment.mvp.ui

import com.congda.baselibrary.base.BaseMvpFragment
import com.congda.jianxin.R
import com.congda.jianxin.ui.fragment.mvp.contract.SecondContract
import com.congda.jianxin.ui.fragment.mvp.presenter.SecondPresenter

class SecondFragment : BaseMvpFragment<SecondPresenter>(),SecondContract.View{
    override fun getLayoutId(): Int {
        return R.layout.fragment_second
    }

    override fun createPresenter(): SecondPresenter {
        return  SecondPresenter()
    }

    override fun initView() {
    }

    override fun initListener() {
    }

    override fun initData() {
    }

    override fun useEventBus(): Boolean {
        return false
    }
}
