package com.weichao.keshi.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import com.weichao.keshi.R;
import com.weichao.keshi.adapter.MyPagerAdapter;
import com.weichao.keshi.fragment.CooFra;
import com.weichao.keshi.fragment.CooMainFragment;
import java.util.ArrayList;
import cn.hugeterry.coordinatortablayout.CoordinatorTabLayout;

/**
 * Created by hugeterry(http://hugeterry.cn)
 * Date: 17/1/28 17:32
 */
public class CooTabActivity extends BaseActivity {
    private CoordinatorTabLayout mCoordinatorTabLayout;
    private int[] mImageArray, mColorArray;
    private ArrayList<Fragment> mFragments;
    private final String[] mTitles = {"学校介绍","校内新闻","通知公告" };
    private ViewPager mViewPager;
    private FragmentManager supportFragmentManager;

    @Override
    int getLayoutId() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        return R.layout.activity_test;
    }

    @Override
    Activity getmActivity() {
        return CooTabActivity.this;
    }

    @Override
    void initView() {
        initFragments();
        initViewPager();


    }

    @Override
    void initData() {
        //头部图片
        mImageArray = new int[]{R.mipmap.bg_android, R.mipmap.bg_ios, R.mipmap.bg_js, R.mipmap.bg_other};
        //头部颜色
        mColorArray = new int[]{android.R.color.holo_purple, android.R.color.holo_red_light,
                android.R.color.holo_orange_light, android.R.color.holo_green_light};

        mCoordinatorTabLayout = (CoordinatorTabLayout) findViewById(R.id.coordinatortablayout);
        mCoordinatorTabLayout.setTitle("科师有约")
                .setBackEnable(true)//返回按钮
                .setImageArray(mImageArray, mColorArray)
                .setupWithViewPager(mViewPager);
    }

    @Override
    void initListener() {

    }

    @Override
    void processClick(View v) {

    }

    @Override
    protected void BarRightClick() {

    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        mFragments.add(CooFra.getInstance(mTitles[0]));
        mFragments.add(new CooFra());
        mFragments.add(CooMainFragment.getInstance(mTitles[1]));
    }

    private void initViewPager() {

        mViewPager = (ViewPager) findViewById(R.id.vp);
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), mFragments, mTitles));
    }

    public FragmentManager getSupportFragmentManager() {
        return supportFragmentManager;
    }
}