package com.weichao.keshi.utils;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.weichao.keshi.R;

import java.io.File;
import java.io.Serializable;

/**
 * @ 创建时间: 2017/8/21 on 19:39.
 * @ 描述：Glide图片加载
 * @ 作者: 郑卫超 QQ: 2318723605
 */
public class GlideImageLoader implements Serializable {

    public static void displayImage(Activity activity, String path, ImageView imageView, int width, int height) {
        Glide.with(activity)                             //配置上下文
                .load(Uri.fromFile(new File(path)))      //设置图片路径(fix #8,文件名包含%符号 无法识别和显示)
                .error(R.mipmap.default_image)           //设置错误图片
                .placeholder(R.mipmap.default_image)     //设置占位图片
                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                .into(imageView);
    }

    public static void displayImage(Context context, Object path, ImageView imageView) {
        //Glide 加载图片
        Glide.with(context).load(path).into(imageView);
    }

    public void clearMemoryCache() {
    }
}
