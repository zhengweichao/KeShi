package com.weichao.keshi.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.weichao.keshi.R;

/**
 * @ 创建时间: 2017/5/14 on 11:16.
 * @ 描述：
 * @ 作者: 郑卫超 QQ: 2318723605
 */

public abstract class BaseActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //得到布局文件
        setContentView(getLayoutId());

        //初始化View
        initView();

        //初始化界面数据
        initData();

        //绑定监听器与适配器
        initListener();
    }

    /**
     *  初始化标题栏
     * @param title 标题文字
     * @param text_bt_right  右侧按钮文字
     */
    public void initBar(final String title, final String text_bt_right) {
        final Activity activity=getmActivity();
        Button bt_bar_left = (Button) activity.findViewById(R.id.bt_bar_back);
        Button bt_bar_right = (Button) activity.findViewById(R.id.bt_bar_enter);
        bt_bar_right.setText(text_bt_right);
        TextView tv_bar_title = (TextView) activity.findViewById(R.id.tv_bar_title);
        tv_bar_title.setText(title);
        bt_bar_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onBackPressed();
            }
        });
        bt_bar_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BarRightClick();
            }
        });
    }

    /**
     * 对统一的按钮进行统一处理
     * @param v 点击的View
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                processClick(v);
                break;
        }
    }

    /**
     * @return 布局文件id
     */
    abstract int getLayoutId();

    /**
     * @return Activity
     */
    abstract Activity getmActivity();

    /**
     * 初始化View
     */
    abstract void initView();

    /**
     * 初始化界面数据
     */
    abstract void initData();

    /**
     * 绑定监听器与适配器
     */
    abstract void initListener();

    /**
     * 点击事件
     * @param v 点击的View
     */
    abstract void processClick(View v);

    /**
     * 标题栏右侧按钮点击事件
     */
    protected abstract void BarRightClick();

    /**
     * 吐司
     */
    public void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * log日志输出
     */
    public void LogE(String msg){
        Log.e("zwc", "LogE: "+msg);;
    }

}
