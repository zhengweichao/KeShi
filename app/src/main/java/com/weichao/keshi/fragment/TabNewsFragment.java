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
 * @ 创建时间: 2017/9/21 on 19:39.
 * @ 描述：新闻页面fragment
 * @ 作者: 郑卫超 QQ: 2318723605
 */
public class TabNewsFragment extends BaseFragment {
    private CoordinatorTabLayout mCoordinatorTabLayout;
    private int[] mImageArray, mColorArray;
    private ViewPager mViewPager;
    private final String[] mTitles = {"通知公告", "新闻速递","自媒体" ,"校园文化" };
    private ArrayList<Fragment> mFragments;

    @Override
    protected View initView() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_news, null);
        mViewPager = (ViewPager) inflate.findViewById(R.id.vp_news);
        mCoordinatorTabLayout = (CoordinatorTabLayout) inflate.findViewById(R.id.cootablayout_news);
        return inflate;
    }

    @Override
    public void initData() {

        initFragments();
        initViewPager();

        mImageArray = new int[]{
                R.mipmap.keshi1,
                R.mipmap.keshi4,
                R.mipmap.img_bg_news3,
                R.mipmap.img_bg_news4};
        mColorArray = new int[]{
                android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_green_light};

        mCoordinatorTabLayout.setTransulcentStatusBar(mActivity)
                .setTitle("")
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
