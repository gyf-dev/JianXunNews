package com.gyf.jianxunnews.model;

import com.apkfuns.logutils.LogUtils;
import com.gyf.jianxunnews.http.RetrofitHttp;
import com.gyf.jianxunnews.model.bean.TodayBean;
import com.gyf.jianxunnews.model.listener.OnLoadJokeListListener;
import com.gyf.jianxunnews.model.listener.OnLoadListListener;

import java.util.List;

import io.reactivex.internal.observers.BlockingBaseObserver;

/**
 * Created by geyifeng on 2017/4/11.
 */

public class TodayModel implements ITodayModel {
    @Override
    public void load(String data, final OnLoadListListener listener) {
        RetrofitHttp.getInstance().loadToday(data, new BlockingBaseObserver<TodayBean>() {
            @Override
            public void onNext(TodayBean todayBean) {
                List<TodayBean.ShowapiResBodyBean.ListBean> list = todayBean.getShowapi_res_body().getList();
                listener.onSuccess(list);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
