package com.congda.tianjianxin.ui.activity

import android.view.View
import android.widget.CheckedTextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.congda.baselibrary.base.BaseActivity
import com.congda.baselibrary.utils.IMStatusBarUtil
import com.congda.tianjianxin.R
import com.congda.tianjianxin.adapter.MyViewPagerAdapter
import com.congda.tianjianxin.ui.fragment.mvp.ui.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), ViewPager.OnPageChangeListener, View.OnClickListener {
    var exitTime: Long = 0
    var mLastIndex = 0
    var mFragments: MutableList<Fragment> = mutableListOf()
    lateinit var mAdapter: MyViewPagerAdapter
    lateinit var mCheckedTextViews: Array<CheckedTextView?>

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        setSwipeBackEnable(false)
    }
    override fun initListener() {
    }

    override fun initStatusBar() {
        IMStatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null)
        IMStatusBarUtil.setLightMode(this)
    }

    override fun initData() {
        viewpage.isCanScrollble = true
        viewpage.offscreenPageLimit = 3
        mFragments.add(FirstFragment())
        mFragments.add(ListFirstFragment())
        mFragments.add(ThirdeFragment())
        mFragments.add(FourthFragment())
        mAdapter = MyViewPagerAdapter(getSupportFragmentManager(), mFragments)
        viewpage.setAdapter(mAdapter)
        viewpage.addOnPageChangeListener(this)
        initTabs()
    }

    private fun initTabs() {
        mCheckedTextViews = arrayOfNulls<CheckedTextView>(tabs.childCount)
        for (i in 0 until tabs.childCount) {
            mCheckedTextViews[i] = tabs.getChildAt(i) as CheckedTextView
            mCheckedTextViews[i]?.setOnClickListener(this)
        }
    }

    override fun onPageScrollStateChanged(state: Int) {

    }
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }
    override fun onPageSelected(position: Int) {
        if (position == mLastIndex) {
            return
        }
        mCheckedTextViews[position]!!.isChecked = true
        mCheckedTextViews[mLastIndex]!!.isChecked = false
        mLastIndex = position
    }
    override fun onClick(v: View?) {
        for (i in mCheckedTextViews.indices) {
            if (v === mCheckedTextViews[i]) {
                if (i == mLastIndex) {
                    break
                }
                mCheckedTextViews[i]!!.isChecked = true
                mCheckedTextViews[mLastIndex]!!.isChecked = false
                mLastIndex = i
                viewpage.setCurrentItem(i, false)
                break
            }
        }
    }

    override fun onBackPressed() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show()
            exitTime = System.currentTimeMillis()
        } else {
            finish()
        }
    }
}