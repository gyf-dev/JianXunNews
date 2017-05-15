package com.gyf.jianxunnews.mvp.presenter;

import com.gyf.jianxunnews.mvp.ui.view.BaseView;

/**
 * Created by geyifeng on 2017/4/27.
 */

public abstract class BasePresenter<T> {

    public T mView;

    public void attachView(T mView) {
        this.mView = mView;
    }

    public void dettachView() {
        mView = null;
    }
}