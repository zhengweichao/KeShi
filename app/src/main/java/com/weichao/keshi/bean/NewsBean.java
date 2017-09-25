package com.weichao.keshi.bean;

import com.weichao.keshi.R;

import xyz.zpayh.adapter.BaseViewHolder;
import xyz.zpayh.adapter.IMultiItem;

/**
 * @ 创建时间: 2017/9/19 on 22:37.
 * @ 描述：
 * @ 作者: 郑卫超 QQ: 2318723605
 */

public class NewsBean {

    private String title;
    private String author;
    private String time;
    private String tag;
    private String pic1;
    private String pic2;
    private String pic3;


    public NewsBean() {
    }

    public NewsBean(String title, String author, String time) {
        this.title = title;
        this.author = author;
        this.time = time;
    }

    public NewsBean(String title, String author, String time, String tag) {
        this.title = title;
        this.author = author;
        this.time = time;
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public String getPic3() {
        return pic3;
    }

    public void setPic3(String pic3) {
        this.pic3 = pic3;
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
}
