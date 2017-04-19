package com.gyf.jianxunnews.model.listener;

import com.gyf.jianxunnews.model.bean.IJokeBean;
import com.gyf.jianxunnews.model.bean.JokeTextBean;

import java.util.List;

/**
 * Created by geyifeng on 2017/3/30.
 */

public interface OnLoadJokeListListener {
    void onSuccess(IJokeBean jokeBean);
    void onFail(Throwable e);
}
