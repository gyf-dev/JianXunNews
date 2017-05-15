package com.gyf.jianxunnews.mvp.model;

import com.gyf.jianxunnews.mvp.model.bean.JokeBean;
import com.gyf.jianxunnews.mvp.model.listener.OnLoadListener;

import java.util.Map;

/**
 * Created by geyifeng on 2017/3/30.
 */

public interface IJokeModel {
    void onLoad(String jokeType, Map<String, String> map, OnLoadListener<JokeBean> listener);
}
