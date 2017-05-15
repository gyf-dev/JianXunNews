package com.gyf.jianxunnews.mvp.model.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by geyifeng on 2017/5/3.
 */

public class NewsMultipleItem implements MultiItemEntity {
    public static final int SLIDESHOW = 1;
    public static final int NEWS_ONE = 2;
    private int itemType;

    public NewsMultipleItem(int itemType){
        this.itemType = itemType;
    }
    @Override
    public int getItemType() {
        return itemType;
    }
}
