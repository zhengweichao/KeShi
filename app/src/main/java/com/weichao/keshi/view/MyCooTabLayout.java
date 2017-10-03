package com.weichao.keshi.view;

import android.app.ActionBar;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;

import cn.hugeterry.coordinatortablayout.CoordinatorTabLayout;

/**
 * @ 创建时间: 2017/10/2 on 12:19.
 * @ 描述：自定义 CoordinatorTabLayout 布局
 * @ 作者: 郑卫超 QQ: 2318723605
 */


public class MyCooTabLayout extends CoordinatorTabLayout {
    private android.support.v7.app.ActionBar mActionbar;

    public MyCooTabLayout(Context context) {
        super(context);
        mActionbar = ((AppCompatActivity) context).getSupportActionBar();
    }

    public MyCooTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCooTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public CoordinatorTabLayout setBackEnable(Boolean canBack) {
        if (canBack) {
            mActionbar.setDisplayHomeAsUpEnabled(true);
            mActionbar.setHomeAsUpIndicator(cn.hugeterry.coordinatortablayout.R.drawable.ic_arrow_white_24dp);

        }
        return this;
    }
}
