package com.gyf.jianxunnews.mvp.model;


import com.gyf.jianxunnews.mvp.model.bean.TodayBean;
import com.gyf.jianxunnews.mvp.model.listener.OnLoadListener;

/**
 * Created by geyifeng on 2017/4/11.
 */

public interface ITodayModel {
    void load(String s, OnLoadListener<TodayBean> listener);
}
