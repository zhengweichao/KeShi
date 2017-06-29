package com.weichao.keshi.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.weichao.keshi.R;

public class PicDetailActivity extends AppCompatActivity {

    private TextView tv_desc;
    private ImageView iv_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_detail);

//        InitBarUtils.initbar("图片展示","上传图片",PicDetailActivity.this,UploadActivity.class);
        initview();
        initdata();
    }


    private void initdata() {
        // TODO: 2017/4/16 接收传递来的bean对象
        int  position = getIntent().getExtras().getInt("position");
        tv_desc.setText("这是第"+position+"张图片");
//        iv_detail.setBackgroundResource(getIntent().getExtras().getInt("id"));
        iv_detail.setImageResource(getIntent().getExtras().getInt("id"));
        /*ArrayList<ListBean> aa = (ArrayList<ListBean>) getIntent().getSerializableExtra("aa");
        iv_detail.setBackgroundResource(aa.get(position).getIconId());*/
    }

    private void initview() {
        tv_desc = (TextView) findViewById(R.id.tv_description);
        iv_detail = (ImageView) findViewById(R.id.iv_detail);
    }
}
