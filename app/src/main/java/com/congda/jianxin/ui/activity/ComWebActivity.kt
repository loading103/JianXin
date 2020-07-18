package com.congda.jianxin.ui.activity

import android.text.TextUtils
import android.widget.LinearLayout
import com.congda.baselibrary.base.BaseActivity
import com.congda.baselibrary.utils.IMStatusBarUtil
import com.congda.jianxin.R
import com.just.agentweb.AgentWeb
import kotlinx.android.synthetic.main.activity_common_web.*

/**
 * Created by Wolf on 2019/11/30.
 * Describe:通用webView
 */
class ComWebActivity : BaseActivity() {

    lateinit var url   :   String
    lateinit var title :    String
    lateinit var  mAgentWeb : AgentWeb
    override fun getLayoutId(): Int {
        return R.layout.activity_common_web
    }

    override fun initStatusBar() {
        IMStatusBarUtil.setTranslucent(this, 0)
        IMStatusBarUtil.setLightMode(this)
    }

    override fun initView() {
        url=intent.getStringExtra("url");
        title=intent.getStringExtra("title");
        if(TextUtils.isEmpty(url)){
            return
        }
        if(!TextUtils.isEmpty(title)){
            common_top.setTopTitle(title)
        }
    }


    override fun initData() {
        mAgentWeb = AgentWeb.with(this)
            .setAgentWebParent(ll_root, LinearLayout.LayoutParams(-1, -1))
            .useDefaultIndicator()
            .createAgentWeb()
            .ready()
            .go(url)
    }


    override fun onPause() {
        mAgentWeb.webLifeCycle.onPause()
        super.onPause()
    }

    override fun onResume() {
        mAgentWeb.webLifeCycle.onResume()
        super.onResume()
    }

    override fun onDestroy() {
        mAgentWeb.webLifeCycle.onDestroy()
        super.onDestroy()
    }

    override fun initListener() {
    }

}