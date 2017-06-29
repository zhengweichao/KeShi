package com.weichao.keshi.bean;

import java.io.Serializable;

/**
 * @Description:列表内容的Bean
 */
public class ListBean implements Serializable{
    private String name;
    private int iconId;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }
}
