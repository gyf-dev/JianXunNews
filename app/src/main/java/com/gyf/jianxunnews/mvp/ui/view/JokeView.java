package com.gyf.jianxunnews.mvp.ui.view;

import com.gyf.jianxunnews.mvp.model.bean.JokeBean;

import java.util.List;

/**
 * Created by geyifeng on 2017/4/27.
 */

public interface JokeView extends BaseView {
    void onLoadSuccess(List<JokeBean.ListBean> list, int allPages);
    void onLoadFail();
}
