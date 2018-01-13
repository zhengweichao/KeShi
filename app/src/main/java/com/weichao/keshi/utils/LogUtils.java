package com.weichao.keshi.utils;

import android.util.Log;

/**
 * @ 创建时间: 2017/8/23 on 13:25.
 * @ 描述：log工具类
 * @ 作者: 郑卫超 QQ: 2318723605
 */
public class LogUtils {
    static boolean islog = true;//    是否打印log
    static String className;//类名
    static String methodName;//方法名
    static int lineNumber;//行数

    private static String createLog(String log) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(methodName);
        buffer.append("(").append(className).append(":").append(lineNumber).append(")");
        buffer.append(log);
        return buffer.toString();
    }

    private static void getMethodNames(StackTraceElement[] sElements) {
        className = sElements[1].getFileName();
        methodName = sElements[1].getMethodName();
        lineNumber = sElements[1].getLineNumber();
    }

    public static void e(String message) {
        if (islog) {
            // Throwable instance must be created before any methods
            getMethodNames(new Throwable().getStackTrace());
            Log.e("zwc", createLog(message));
        }
    }

    public static void i(String message) {
        if (islog) {
            // Throwable instance must be created before any methods
            getMethodNames(new Throwable().getStackTrace());
            Log.i("zwc", createLog(message));
        }
    }
}
