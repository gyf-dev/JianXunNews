package com.gyf.jianxunnews.mvp.ui.view;

import com.gyf.jianxunnews.mvp.model.bean.TodayBean;

import java.util.List;

/**
 * Created by geyifeng on 2017/4/27.
 */

public interface TodayView extends BaseView {
    void onLoadSuccess(List<TodayBean.ListBean> list);
    void onLoadFail();
}
