package com.gyf.jianxunnews.presenter;

import com.apkfuns.logutils.LogUtils;
import com.gyf.jianxunnews.model.bean.TodayBean;
import com.gyf.jianxunnews.model.listener.OnLoadListListener;
import com.gyf.jianxunnews.ui.view.IBaseView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by geyifeng on 2017/4/11.
 */

public class TodayPresenter extends BasePresenter implements ITodayPresenter, OnLoadListListener<TodayBean.ShowapiResBodyBean.ListBean> {

    private IBaseView baseView;

    @Inject
    public TodayPresenter(IBaseView baseView) {
        this.baseView = baseView;
    }

    @Override
    public void load(String date) {
        baseView.showProgress();
    }

    @Override
    public void onSuccess(List<TodayBean.ShowapiResBodyBean.ListBean> list) {
        baseView.hideProgress();
    }

    @Override
    public void onFail(Throwable e) {
        baseView.hideProgress();
    }
}
