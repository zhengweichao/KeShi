package com.weichao.keshi.bean;

/**
 * @ 创建时间: 2017/5/24 on 10:27.
 * @ 描述：通讯录条目
 * @ 作者: 郑卫超 QQ: 2318723605
 */

public class NumNoteItem {
    private String num;
    private String name;
    private String type;

    public NumNoteItem(String num,String name,String type) {
        this.name=name;
        this.num=num;
        this.type=type;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
