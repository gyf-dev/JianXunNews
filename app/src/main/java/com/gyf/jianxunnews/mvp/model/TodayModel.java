package com.gyf.jianxunnews.mvp.model;

import com.gyf.jianxunnews.http.RetrofitHttp;
import com.gyf.jianxunnews.mvp.model.bean.TodayBean;
import com.gyf.jianxunnews.mvp.model.listener.OnLoadListener;
import com.gyf.jianxunnews.utils.UrlUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by geyifeng on 2017/4/11.
 */

public class TodayModel implements ITodayModel {
    @Override
    public void load(String date, final OnLoadListener<TodayBean> listener) {
        RetrofitHttp.getInstance()
                .baseUrl(UrlUtil.TODAY_URL)
                .loadToday(date, new Observer<TodayBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TodayBean todayBean) {
                        listener.onSuccess(todayBean);
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
