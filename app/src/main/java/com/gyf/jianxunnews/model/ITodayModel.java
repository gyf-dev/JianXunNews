package com.gyf.jianxunnews.model;

import com.gyf.jianxunnews.model.listener.OnLoadListListener;

/**
 * Created by geyifeng on 2017/4/11.
 */

public interface ITodayModel {
    void load(String s, OnLoadListListener listener);
}
