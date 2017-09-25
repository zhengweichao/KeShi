package com.weichao.keshi.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.weichao.keshi.R;
import com.weichao.keshi.cootab.MainFragment1;
import com.weichao.keshi.cootab.MainFragment2;
import com.weichao.keshi.cootab.MainFragment3;
import com.weichao.keshi.cootab.MainFragment4;
import com.weichao.keshi.cootab.MyPagerAdapter;

import java.util.ArrayList;

import cn.hugeterry.coordinatortablayout.CoordinatorTabLayout;


/**
 * Created by 郑卫超 on 2017/5/3.
 * Email: Matthew_Chen_1994@163.com
 * Blog: https://blog.ifmvo.cn
 */

public class TabFragment4 extends BaseFragment {

    private CoordinatorTabLayout mCoordinatorTabLayout;
    private int[] mImageArray, mColorArray;
    private ViewPager mViewPager;
    private final String[] mTitles = {"学校介绍", "校内新闻", "通知公告","aaa"};
    private ArrayList<Fragment> mFragments;

    @Override
    protected View initView() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.activity_test, null);
        mViewPager = (ViewPager) inflate.findViewById(R.id.vp);
        mCoordinatorTabLayout = (CoordinatorTabLayout) inflate.findViewById(R.id.coordinatortablayout);
        return inflate;
    }

    @Override
    public void initData() {
        initFragments();
        initViewPager();

        mImageArray = new int[]{
                R.mipmap.bg_android,
                R.mipmap.bg_ios,
                R.mipmap.bg_js,
                R.mipmap.bg_other};
        mColorArray = new int[]{
                android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_green_light};

        mCoordinatorTabLayout.setTransulcentStatusBar(mActivity)
                .setTitle("")
//                .setBackEnable(true)
                .setImageArray(mImageArray, mColorArray)
                .setupWithViewPager(mViewPager);
    }

    @Override
    public void initListener() {

    }
    private void initViewPager() {
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setAdapter(new MyPagerAdapter(getChildFragmentManager(), mFragments, mTitles));
    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        mFragments.add(MainFragment1.getInstance(mTitles[0]));
        mFragments.add(MainFragment2.getInstance(mTitles[1]));
        mFragments.add(MainFragment3.getInstance(mTitles[2]));
        mFragments.add(MainFragment4.getInstance(mTitles[3]));
    }


}
