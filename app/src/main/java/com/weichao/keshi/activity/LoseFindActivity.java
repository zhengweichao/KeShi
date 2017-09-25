package com.weichao.keshi.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.weichao.keshi.R;

import java.util.HashMap;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

/**
 * @ 创建时间: 2017/5/22 on 08:09.
 * @ 描述：失物招领页面
 * @ 作者: 郑卫超 QQ: 2318723605
 */
public class LoseFindActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose_find);
//        SMSSDK.initSDK(this, "1e434cd6d52f8", "2b4c6025debb8f83b6087449036877ad");

        //打开注册页面
        RegisterPage registerPage = new RegisterPage();
        EventHandler eventHandler = new EventHandler() {

            public void afterEvent(int event, int result, Object data) {
                // 解析注册结果
                if (result == SMSSDK.RESULT_COMPLETE) {
                    @SuppressWarnings("unchecked")
                    HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                    String country = (String) phoneMap.get("country");
                    String phone = (String) phoneMap.get("phone");

                    // 提交用户信息（此方法可以不调用）
                    //                    registerUser(country, phone);
                }
            }
        };
        registerPage.setRegisterCallback(eventHandler);
        registerPage.show(LoseFindActivity.this);
        SMSSDK.registerEventHandler(eventHandler);

    }
}
