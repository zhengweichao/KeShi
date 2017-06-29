package com.weichao.keshi.bean;

/**
 * 创建日期:2016/12/6 on 12:49
 * 描述:
 * 作者:郭士超
 * QQ:1169380200
 */

public class KeyValue {
    private String key;
    private String valueStr;
    private boolean valueBool;


    public KeyValue(String key, String valueStr) {
        this.key = key;
        this.valueStr = valueStr;
        valueBool = false;
    }

    public KeyValue(String key, boolean valueBool) {
        this.key = key;
        this.valueBool = valueBool;
        valueStr = "";
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


    public String getValueStr() {
        return valueStr;
    }

    public void setValueStr(String valueStr) {
        this.valueStr = valueStr;
    }

    public boolean isValueBool() {
        return valueBool;
    }

    public void setValueBool(boolean valueBool) {
        this.valueBool = valueBool;
    }


}
