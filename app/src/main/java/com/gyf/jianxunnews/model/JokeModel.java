package com.gyf.jianxunnews.model;


import android.view.Window;

import com.gyf.jianxunnews.http.RetrofitHttp;
import com.gyf.jianxunnews.model.bean.IJokeBean;
import com.gyf.jianxunnews.model.listener.OnLoadJokeListListener;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

import io.reactivex.internal.observers.BlockingBaseObserver;
import io.reactivex.observers.SafeObserver;

/**
 * Created by geyifeng on 2017/3/30.
 */

public class JokeModel implements IJokeModel {

    @Override
    public void loadTextJoke(Map<String, String> map, OnLoadJokeListListener listener) {
        RetrofitHttp.getInstance().loadTextJoke(map, new MyObserver(listener));
    }

    @Override
    public void loadPicJoke(Map<String, String> map, OnLoadJokeListListener listener) {
        RetrofitHttp.getInstance().loadPicJoke(map, new MyObserver(listener));
    }

    @Override
    public void loadGifJoke(Map<String, String> map, OnLoadJokeListListener listener) {
        RetrofitHttp.getInstance().loadGifJoke(map, new MyObserver(listener));
    }



    private class MyObserver extends BlockingBaseObserver<IJokeBean> {
        OnLoadJokeListListener listener;

        MyObserver(OnLoadJokeListListener listener) {
            this.listener = listener;
        }

        @Override
        public void onNext(IJokeBean bean) {
            if (bean != null)
                listener.onSuccess(bean);
            else
                listener.onFail(null);
        }

        @Override
        public void onError(Throwable e) {
            //LogUtils.d("onError");
            listener.onFail(e);
        }
    }

}
