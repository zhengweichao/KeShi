package com.weichao.keshi.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.weichao.keshi.R;

import butterknife.ButterKnife;

/**
 * @ 创建时间: 2017/5/17 on 11:16.
 * @ 描述：Activity基类
 * @ 作者: 郑卫超 QQ: 2318723605
 */
public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener {

    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(getLayoutId());
        ButterKnife.bind(this);

        initView();
        initData();
        registComBtn();
        initListener();
    }

    /**
     * 注册共有控件
     */
    final void registComBtn() {
        View btn_back = findViewById(R.id.btn_back);
        if (btn_back != null) {
            btn_back.setOnClickListener(this);
        }
    }

    /**
     * 初始化标题栏
     *
     * @param color
     * @param text
     */
    void initTitleBar(int color, int text) {
        LinearLayout layout_title = (LinearLayout) findViewById(R.id.layout_title);
        layout_title.setBackgroundResource(color);
        TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle.setText(this.getResources().getString(text));
    }

    /**
     * 对统一的按钮进行统一处理
     *
     * @param v 点击的View
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            default:
                processClick(v);
                break;
        }
    }

    /**
     * @return 布局文件id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化View
     */
    void initView() {
    }

    /**
     * 初始化界面数据
     */
    void initData() {
    }

    /**
     * 绑定监听器与适配器
     */
    void initListener() {
    }

    /**
     * 点击事件
     *
     * @param v 点击的View
     */
    void processClick(View v) {
    }

}
