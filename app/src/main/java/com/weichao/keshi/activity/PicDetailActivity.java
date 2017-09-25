package com.weichao.keshi.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.weichao.keshi.R;

public class PicDetailActivity extends BaseActivity {

    private TextView tv_desc;
    private ImageView iv_detail;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pic_detail;
    }

    @Override
    void initView() {
        tv_desc = (TextView) findViewById(R.id.tv_description);
        iv_detail = (ImageView) findViewById(R.id.iv_detail);
    }

    @Override
    void initData() {
        // TODO: 2017/4/16 接收传递来的bean对象
        int position = getIntent().getExtras().getInt("position");
        tv_desc.setText("这是第" + position + "张图片");
        iv_detail.setImageResource(getIntent().getExtras().getInt("id"));
    }

}
