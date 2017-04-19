package com.gyf.jianxunnews.ui.view;


import java.util.List;

/**
 * Created by geyifeng on 2017/3/30.
 */

public interface IBaseView<T> {
    void showProgress();
    void onLoadSuccess(List<T> list, int allPages);
    void onLoadFail();
    void hideProgress();
}
