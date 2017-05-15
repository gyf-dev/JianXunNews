package com.gyf.jianxunnews.mvp.presenter;

import com.apkfuns.logutils.LogUtils;
import com.gyf.jianxunnews.mvp.model.ITodayModel;
import com.gyf.jianxunnews.mvp.model.TodayModel;
import com.gyf.jianxunnews.mvp.model.bean.TodayBean;
import com.gyf.jianxunnews.mvp.model.listener.OnLoadListener;
import com.gyf.jianxunnews.mvp.ui.view.TodayView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by geyifeng on 2017/4/27.
 */

public class TodayPresenter extends BasePresenter<TodayView> implements ITodayPresenter, OnLoadListener<TodayBean> {

    private ITodayModel mTodayModel;

    public TodayPresenter() {
        mTodayModel = new TodayModel();
    }

    @Override
    public void load() {
        mView.showProgress();
        String date = new SimpleDateFormat("MMdd").format(new Date());
        mTodayModel.load(date, this);
    }

    @Override
    public void onSuccess(TodayBean data) {
        mView.onLoadSuccess(data.getList());
        mView.hideProgress();
    }

    @Override
    public void onFail(Throwable e) {
        mView.onLoadFail();
        mView.hideProgress();
    }
}
