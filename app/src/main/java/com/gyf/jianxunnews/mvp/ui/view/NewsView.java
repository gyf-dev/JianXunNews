package com.gyf.jianxunnews.mvp.ui.view;


import com.gyf.jianxunnews.mvp.model.bean.NewsBean;

import java.util.List;

/**
 * Created by geyifeng on 2017/5/3.
 */

public interface NewsView extends BaseView {
    void onLoadSuccess(List<NewsBean> list);
    void onLoadFail();
}
