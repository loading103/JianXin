package com.congda.jianxin.ui.activity.mvp.contract;


import com.congda.baselibrary.mvp.IModel;
import com.congda.baselibrary.mvp.IView;

public interface ComWebViewContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void setmValueListCallbackNull();
    }

    interface Model extends IModel {

    }

}
