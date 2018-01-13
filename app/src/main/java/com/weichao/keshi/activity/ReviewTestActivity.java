package com.weichao.keshi.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.weichao.keshi.R;

/**
 * 答题页面（正在开发）
 */
public class ReviewTestActivity extends BaseActivity {

    private Button btnSxlx;
    private Button btnSjlx;
    private Button btnZjlx;
    private Button btnLaw;
    private Button btnMnks;
    private Button btnCollection;
    private Button btnCtjlb;
    private Button btnPoint;
    private Button btnCheats;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_an_home;
    }

    @Override
    void initView() {
//      找控件

        /*该部分留作扩展
        btnSxlx = (Button) findViewById(R.id.btn_sxlx);
        btnSjlx = (Button) findViewById(R.id.btn_sjlx);
        btnCtjlb = (Button) findViewById(R.id.btn_ctjlb);
        btnZjlx = (Button) findViewById(R.id.btn_zjlx);*/
        btnMnks = (Button) findViewById(R.id.btn_mnks);
        btnLaw = (Button) findViewById(R.id.btn_law);
        btnCollection = (Button) findViewById(R.id.btn_collection);
        btnPoint = (Button) findViewById(R.id.btn_point);
        btnCheats = (Button) findViewById(R.id.btn_cheats);

    }

    @Override
    void initData() {

    }

    @Override
    void initListener() {
        btnLaw.setOnClickListener(this);
        /*该部分留作扩展
        btnSxlx.setOnClickListener(this);
        btnSjlx.setOnClickListener(this);
        btnCtjlb.setOnClickListener(this);
        btnZjlx.setOnClickListener(this);
        */
        btnMnks.setOnClickListener(this);
        btnCollection.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btnCheats.setOnClickListener(this);
    }

    @Override
    void processClick(View v) {
        switch (v.getId()) {
//            点击开始答题，则带参传递，跳转页面，默认选择题
            case R.id.btn_mnks:
                // TODO: 2017/6/13 开始答题
                Intent intent1 = new Intent(ReviewTestActivity.this, AnswerActivity.class);
                intent1.putExtra("type", 1);
                startActivity(intent1);
                break;

//            该部分留作以后扩展增加功能使用
            /*case R.id.btn_sxlx:
                //  2017/6/13 顺序练习

                break;
            case R.id.btn_sjlx:
                //  2017/6/13 随机练习
                Intent intent2 = new Intent(ReviewTestActivity.this, AnswerActivity.class);
                intent2.putExtra("type",2);
                startActivity(intent2);
                break;
            case R.id.btn_zjlx:
                //  2017/6/13 章节练习
                break;
            case R.id.btn_ctjlb:

                break;*/

            case R.id.btn_point:
                // TODO: 2017/6/13 选择题
                Intent intent3 = new Intent(ReviewTestActivity.this, AnswerActivity.class);
                intent3.putExtra("type", 1);
                startActivity(intent3);
                break;

            case R.id.btn_law:
                // TODO: 2017/6/13 判断题
                Intent intent4 = new Intent(ReviewTestActivity.this, AnswerActivity.class);
                intent4.putExtra("type", 2);
                startActivity(intent4);
                break;

            case R.id.btn_cheats:
                // TODO: 2017/6/13 简答题
                Intent intent5 = new Intent(ReviewTestActivity.this, AnswerActivity.class);
                intent5.putExtra("type", 3);
                startActivity(intent5);
                break;

            case R.id.btn_collection:
                // TODO: 2017/6/13 关于
                Intent intent6 = new Intent(ReviewTestActivity.this, AboutActivity.class);
                startActivity(intent6);
                break;

            default:
                break;
        }
    }


}
