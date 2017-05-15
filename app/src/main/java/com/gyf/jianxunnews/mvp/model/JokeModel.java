package com.gyf.jianxunnews.mvp.model;


import com.gyf.jianxunnews.http.RetrofitHttp;
import com.gyf.jianxunnews.mvp.model.bean.JokeBean;
import com.gyf.jianxunnews.mvp.model.listener.OnLoadListener;
import com.gyf.jianxunnews.utils.UrlUtil;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by geyifeng on 2017/3/30.
 */

public class JokeModel implements IJokeModel {

    @Override
    public void onLoad(String jokeType, Map<String, String> map, final OnLoadListener<JokeBean> listener) {
        RetrofitHttp.getInstance()
                .baseUrl(UrlUtil.JOKE_URL)
                .loadJoke(jokeType, map, new Observer<JokeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JokeBean jokeBean) {
                        listener.onSuccess(jokeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onFail(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
