package com.weichao.keshi.bean;

import android.text.TextUtils;

import com.facebook.drawee.view.SimpleDraweeView;
import com.weichao.keshi.R;
import com.weichao.keshi.utils.FrescoUtil;
import com.weichao.keshi.utils.LogUtils;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;
import xyz.zpayh.adapter.BaseViewHolder;
import xyz.zpayh.adapter.IMultiItem;

/**
 * @ 创建时间: 2017/10/4 on 10:32.
 * @ 描述：表白墙
 * @ 作者: 郑卫超 QQ: 2318723605
 */

public class LoveBean extends BmobObject implements IMultiItem, Serializable {

    private String author;
    private String touser;
    private String content;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_love;
    }

    @Override
    public void convert(BaseViewHolder holder) {
        LogUtils.e("填充数据~~~~~");
        holder.setText(R.id.tv_love_content, content);
        holder.setText(R.id.tv_love_touser, "TO: "+touser);
        holder.setText(R.id.tv_love_author, "FROM： " + author);
    }

    @Override
    public int getSpanSize() {
        return 0;
    }
}
