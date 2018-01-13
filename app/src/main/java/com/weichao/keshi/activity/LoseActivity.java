package com.weichao.keshi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.weichao.keshi.R;
import com.weichao.keshi.cootab.MyPagerAdapter;
import com.weichao.keshi.fragment.LoseFragment1;
import com.weichao.keshi.fragment.LoseFragment2;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.hugeterry.coordinatortablayout.CoordinatorTabLayout;

/**
 * @ 创建时间: 2017/10/3 on 10:03.
 * @ 描述：失物招领页面
 * @ 作者: 郑卫超 QQ: 2318723605
 */
public class LoseActivity extends AppCompatActivity {
    @Bind(R.id.coordinatortablayout)
    CoordinatorTabLayout mCoordinatorTabLayout;
    @Bind(R.id.vp)
    ViewPager mViewPager;
    private int[] mImageArray, mColorArray;
    private final String[] mTitles = {"失物招领", "寻物启事"};
    private ArrayList<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);
        ButterKnife.bind(this);

        initFragments();
        initViewPager();

        mImageArray = new int[]{
                R.mipmap.img_bg_lose,
                R.mipmap.img_bg_find};
        mColorArray = new int[]{
                android.R.color.holo_blue_light,
                android.R.color.holo_red_light};

        mCoordinatorTabLayout.setTransulcentStatusBar(this)
                .setTitle("失物招领")
                .setBackEnable(true)
                .setImageArray(mImageArray, mColorArray)
                .setupWithViewPager(mViewPager);
    }

    private void initViewPager() {
        mViewPager.setOffscreenPageLimit(2);
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), mFragments, mTitles));
    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        mFragments.add(LoseFragment1.getInstance(mTitles[0]));
        mFragments.add(LoseFragment2.getInstance(mTitles[1]));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.iv_add_lose)
    public void onViewClicked() {
        Intent intent = new Intent(LoseActivity.this, LoseAddActivity.class);
        startActivity(intent);
    }
}