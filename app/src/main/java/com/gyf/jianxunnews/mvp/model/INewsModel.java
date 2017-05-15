package com.gyf.jianxunnews.mvp.model;

import com.gyf.jianxunnews.mvp.model.bean.NewsBean;
import com.gyf.jianxunnews.mvp.model.bean.NewsStatusBean;
import com.gyf.jianxunnews.mvp.model.listener.OnLoadListener;

import java.util.Map;

/**
 * Created by geyifeng on 2017/5/3.
 */

public interface INewsModel {
    void load(Map<String, String> map, OnLoadListener<NewsStatusBean.NewsResultBean> listener);
}
