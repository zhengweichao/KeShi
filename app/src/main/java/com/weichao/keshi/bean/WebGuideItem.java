package com.weichao.keshi.bean;

import android.support.annotation.DrawableRes;

/**
 * @ 创建时间: 2017/5/14 on 9:10.
 * @ 描述：模块条目
 * @ 作者: 郑卫超 QQ: 2318723605
 */

public class WebGuideItem {
    @DrawableRes
    private int mImageResId;
    private String mImageTitle;
    private String url;

    public WebGuideItem(int imageResId, String imageTitle, String url) {
        this.mImageResId = imageResId;
        this.mImageTitle = imageTitle;
        this.url=url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getmImageResId() {
        return mImageResId;
    }

    public void setmImageResId(int mImageResId) {
        this.mImageResId = mImageResId;
    }

    public String getmImageTitle() {
        return mImageTitle;
    }

    public void setmImageTitle(String mImageTitle) {
        this.mImageTitle = mImageTitle;
    }
}
