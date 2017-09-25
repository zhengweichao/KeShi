package com.weichao.keshi.cootab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.weichao.keshi.R;
import com.weichao.keshi.fragment.BuyFragment1;
import com.weichao.keshi.fragment.BuyFragment2;
import com.weichao.keshi.fragment.LoseFragment1;
import com.weichao.keshi.fragment.LoseFragment2;

import java.util.ArrayList;

import cn.hugeterry.coordinatortablayout.CoordinatorTabLayout;

public class BuyActivity extends AppCompatActivity {
    private CoordinatorTabLayout mCoordinatorTabLayout;
    private int[] mImageArray, mColorArray;
    private ViewPager mViewPager;
    private final String[] mTitles = {"淘点宝贝", "换点银子"};
    private ArrayList<Fragment> mFragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        initFragments();
        initViewPager();

        mImageArray = new int[]{
                R.mipmap.bg_android,
                R.mipmap.bg_ios};
        mColorArray = new int[]{
                android.R.color.holo_blue_light,
                android.R.color.holo_red_light};

        mCoordinatorTabLayout = (CoordinatorTabLayout) findViewById(R.id.coordinatortablayout);
        mCoordinatorTabLayout.setTransulcentStatusBar(this)
                .setTitle("二手交易")
                .setBackEnable(true)
                .setImageArray(mImageArray, mColorArray)
                .setupWithViewPager(mViewPager);
    }

    private void initViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.vp);
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), mFragments, mTitles));
    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        mFragments.add(BuyFragment1.getInstance(mTitles[0]));
        mFragments.add(BuyFragment2.getInstance(mTitles[1]));
    }
}
