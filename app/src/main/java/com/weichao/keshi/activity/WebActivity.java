package com.weichao.keshi.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.weichao.keshi.R;

public class WebActivity extends BaseActivity {

    private WebView wv;

    @Override
    int getLayoutId() {
        return R.layout.activity_web;
    }

    @Override
    Activity getmActivity() {
        return WebActivity.this;
    }

    @Override
    void initView() {
        wv = (WebView) findViewById(R.id.wv);
    }

    @Override
    void initData() {
        String  url = (String) getIntent().getExtras().get("url");
        LogE("initData: 加载网页");
        MyWebViewClient myWebViewClient = new MyWebViewClient();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
            wv.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);}
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
        LogE("initData: 加载网页完毕");
    }

    @Override
    void initListener() {

    }

    @Override
    void processClick(View v) {

    }

    @Override
    protected void BarRightClick() {

    }
    private class MyWebViewClient extends WebViewClient {
        //重写父类方法，让新打开的网页在当前的WebView中显示
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}
