package com.weichao.keshi.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * @ 创建时间: 2017/6/13 on 17:12.
 * @ 描述：greenDao 学习，测试生成数据库
 * @ 作者: 郑卫超 QQ: 2318723605
 */
public class QuestBean {
    private long id;
    private int q_type;// 题型：0：判断题 1：选择题
    private String title;// 问题
    private String optionA;// 选项A
    private String optionB;// 选项B
    private String optionC;// 选项C
    private String optionD;// 选项D
    private String tips;//提示
    private String explain;//解释
    private String answer;// 正确答案
    private String myanswer;// 我的答案


}
