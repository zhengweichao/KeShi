package com.weichao.keshi.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.weichao.keshi.R;
import com.weichao.keshi.utils.LogUtils;

public class WebActivity extends BaseActivity {

    private WebView wv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_web;
    }

    @Override
    void initView() {
        wv = (WebView) findViewById(R.id.wv);
    }

    @Override
    void initData() {
        String url = (String) getIntent().getExtras().get("url");
        MyWebViewClient myWebViewClient = new MyWebViewClient();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            wv.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        wv.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);//设置js可以直接打开窗口，如window.open()，默认为false
        wv.getSettings().setJavaScriptEnabled(true);//是否允许执行js，默认为false。设置true时，会提醒可能造成XSS漏洞
        wv.getSettings().setSupportZoom(true);//是否可以缩放，默认true
        wv.getSettings().setBuiltInZoomControls(true);//是否显示缩放按钮，默认false
        wv.getSettings().setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式
        wv.getSettings().setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题
        wv.getSettings().setAppCacheEnabled(true);//是否使用缓存
        wv.getSettings().setDomStorageEnabled(true);//DOM Storage
// displayWebview.getSettings().setUserAgentString("User-Agent:Android");//设置用户代理，一般不用

//      settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLAW);
        wv.setWebChromeClient(new WebChromeClient());
        wv.setWebViewClient(myWebViewClient);
        wv.loadUrl(url);
//        wv.loadUrl("javascript:alert('aaa')");
    }

    @Override
    void initListener() {

    }

    @Override
    void processClick(View v) {

    }

    private class MyWebViewClient extends WebViewClient {
        //重写父类方法，让新打开的网页在当前的WebView中显示
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            wv.loadUrl("javascript:$('.titleTips').hide();$('.advertise').hide();$('.provider').hide()");
        }
    }

    private long mExitTime;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub

        if (keyCode == KeyEvent.KEYCODE_BACK && wv.canGoBack()) {
            LogUtils.e("回退ing……");
            wv.goBack();
            return true;
        } else {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出当前页面", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
            } else {
                onBackPressed();
            }
        }
        return true;
    }


}
