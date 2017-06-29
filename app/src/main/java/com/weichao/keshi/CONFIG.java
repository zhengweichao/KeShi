package com.weichao.keshi;


import com.weichao.keshi.bean.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建日期:2016/12/5 on 21:19
 * 描述:
 * 作者:郭士超
 * QQ:1169380200
 */

public class CONFIG {
    //    登录网址
    public static final String URL_LOGIN = "http://123.207.155.175:8080/Examine1/LogLet";
    //    注册网址
    public static final String URL_SIGNUP = "http://123.207.155.175:8080/Examine1/RegLet";
    //    获取问题网址
    public static final String URL_GETQUEST1 = "http://123.207.155.175:8080/Examine1/GetQuestionLet";
    //服务器前缀地址
    public static final String SERVER_URL="http://10.0.2.2:8080/zhbj";
    //新闻中心的地址
    public static final String NEWSCENTER_URL=SERVER_URL+"/categories.json";


    public static final String APP_ID = "com.cc.alarmclock";
    public static final String CHARSET = "utf-8";

    public static final String KEY_TEXT = "text";
    public static final String KEY_COLOR = "color";
    public static final String ERRMSG_401 = "401";//表示token过期
    public static final String ERRMSG_ERR = "err";//表示请求超时
    public static final String ERRMSG_MSG = "请求超时，请检查网络连接";//表示请求超时

    public static List<Message> messageList= new ArrayList<Message>();

}
