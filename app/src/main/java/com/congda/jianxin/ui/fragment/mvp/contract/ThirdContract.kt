package com.congda.jianxin.ui.fragment.mvp.contract

import com.congda.baselibrary.mvp.IModel
import com.congda.baselibrary.mvp.IView

interface ThirdContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View : IView{
    }

    interface Model : IModel{

    }
}