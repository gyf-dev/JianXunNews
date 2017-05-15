package com.gyf.jianxunnews.mvp.model.listener;

/**
 * Created by geyifeng on 2017/3/30.
 */

public interface OnLoadListener<T> {
    void onSuccess(T data);

    void onFail(Throwable e);
}
