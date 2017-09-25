package com.weichao.keshi.activity;

import com.weichao.keshi.R;

/**
 * @ 创建时间: 2017/6/18 on 17:12.
 * @ 描述：关于界面
 * @ 作者: 郑卫超 QQ: 2318723605
 */
public class AboutActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about;
    }

    @Override
    void initView() {
        initTitleBar(R.color.colorPrimary, R.string.app_name);
    }
}
