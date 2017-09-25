package com.weichao.keshi.bean;

import java.io.Serializable;

import cn.bmob.v3.BmobUser;

/**
 * @ 创建时间: 2017/9/18 on 18:47.
 * @ 描述：
 * @ 作者: 郑卫超 QQ: 2318723605
 */

public class MyUser extends BmobUser implements Serializable {
    private String stuno;

    public String getStuno() {
        return stuno;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno;
    }
}
