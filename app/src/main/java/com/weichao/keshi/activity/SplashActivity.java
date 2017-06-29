package com.weichao.keshi.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.weichao.keshi.R;

import cn.smssdk.SMSSDK;

public class SplashActivity extends BaseActivity {
    private Button btn_splash_jump;
    private CountDownTimer countDownTimer = new CountDownTimer(5000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            Log.e("zwc", "onTick: "+ millisUntilFinished);
            btn_splash_jump.setText("跳过(" + millisUntilFinished/ 1000 + "s)");
        }

        @Override
        public void onFinish() {
            btn_splash_jump.setText("跳过(" + 0 + "s)");
            goLoginActivity();
        }
    };

    private void goLoginActivity() {
        //直接跳转主页面
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    Activity getmActivity() {
        return SplashActivity.this;
    }

    @Override
    void initView() {
        btn_splash_jump = (Button) findViewById(R.id.sp_jump_btn);
    }

    @Override
    void initData() {
        btn_splash_jump.setVisibility(View.VISIBLE);
        countDownTimer.start();
    }

    @Override
    void initListener() {
        btn_splash_jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //执行跳转逻辑
                goLoginActivity();
            }
        });
    }

    @Override
    void processClick(View v) {

    }

    @Override
    protected void BarRightClick() {

    }
}
