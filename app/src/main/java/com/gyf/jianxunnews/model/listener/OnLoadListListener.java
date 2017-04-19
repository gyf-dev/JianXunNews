package com.gyf.jianxunnews.model.listener;

import java.util.List;

/**
 * Created by geyifeng on 2017/3/30.
 */

public interface OnLoadListListener<T> {
    void onSuccess(List<T> list);

    void onFail(Throwable e);
}
