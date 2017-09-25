package com.weichao.keshi.bean;

import com.weichao.keshi.R;

import cn.bmob.v3.BmobObject;
import xyz.zpayh.adapter.BaseViewHolder;
import xyz.zpayh.adapter.IMultiItem;

/**
 * @ 创建时间: 2017/9/20 on 16:32.
 * @ 描述：
 * @ 作者: 郑卫超 QQ: 2318723605
 */

public class NewsBean1 extends BmobObject implements IMultiItem {

    private String title;
    private String author;
    private String time;

    public NewsBean1(String title, String author, String time) {
        this.title = title;
        this.author = author;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_news_type1;
    }

    @Override
    public void convert(BaseViewHolder holder) {
        holder.setText(R.id.tv_type1_title, title);
        holder.setText(R.id.tv_type1_author, author);
        holder.setText(R.id.tv_type1_time, time);
    }

    @Override
    public int getSpanSize() {
        return 0;
    }
}
