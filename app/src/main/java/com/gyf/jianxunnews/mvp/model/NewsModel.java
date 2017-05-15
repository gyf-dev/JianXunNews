package com.gyf.jianxunnews.mvp.model;

import com.apkfuns.logutils.LogUtils;
import com.gyf.jianxunnews.http.RetrofitHttp;
import com.gyf.jianxunnews.mvp.model.bean.NewsBean;
import com.gyf.jianxunnews.mvp.model.bean.NewsStatusBean;
import com.gyf.jianxunnews.mvp.model.listener.OnLoadListener;
import com.gyf.jianxunnews.utils.UrlUtil;

import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by geyifeng on 2017/5/3.
 */

public class NewsModel implements INewsModel {
    @Override
    public void load(Map<String, String> map, final OnLoadListener<NewsStatusBean.NewsResultBean> listener) {
        RetrofitHttp.getInstance()
                .baseUrl(UrlUtil.NEWS_URL)
                .loadNews(map, new Observer<NewsStatusBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewsStatusBean newsStatusBean) {
                        listener.onSuccess(newsStatusBean.getResult());
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
