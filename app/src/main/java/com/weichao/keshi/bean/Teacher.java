package com.weichao.keshi.bean;

import cn.bmob.v3.BmobObject;

/**
 * @ 创建时间: 2017/9/18 on 22:04.
 * @ 描述：
 * @ 作者: 郑卫超 QQ: 2318723605
 */

public class Teacher extends BmobObject {
    private String indexTag;
    private String name;
    private String tel;

    public String getIndexTag() {
        return indexTag;
    }

    public void setIndexTag(String indexTag) {
        this.indexTag = indexTag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
