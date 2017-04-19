package com.gyf.jianxunnews.presenter;

import com.gyf.jianxunnews.model.IJokeModel;
import com.gyf.jianxunnews.model.JokeModel;
import com.gyf.jianxunnews.model.bean.IJokeBean;
import com.gyf.jianxunnews.model.bean.JokeImgBean;
import com.gyf.jianxunnews.model.bean.JokeTextBean;
import com.gyf.jianxunnews.model.listener.OnLoadJokeListListener;
import com.gyf.jianxunnews.ui.view.IBaseView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by geyifeng on 2017/3/30.
 */

public class JokePresenter implements IJokePresenter, OnLoadJokeListListener {

    private IBaseView mJockView;
    private IJokeModel mJokeModel;
    private int type;

    @Inject
    public JokePresenter(IBaseView jockView, int type) {
        this.mJockView = jockView;
        mJokeModel = new JokeModel();
        this.type = type;
    }

    @Override
    public void loadJoke(String maxResult, String page) {
        Map<String, String> map = new HashMap<>();
        map.put("maxResult", maxResult);
        map.put("page", page);
        map.put("time", "2016-07-01");
        mJockView.showProgress();
        switch (type) {
            case 1:
                mJokeModel.loadTextJoke(map, this);
                break;
            case 2:
                mJokeModel.loadPicJoke(map, this);
                break;
            case 3:
                mJokeModel.loadGifJoke(map, this);
                break;
        }
    }

    @Override
    public void onSuccess(IJokeBean jokeBean) {
        if (type == 1) {
            JokeTextBean bean = (JokeTextBean) jokeBean;
            List<JokeTextBean.ShowapiResBodyBean.ContentlistBean> list = bean.getShowapi_res_body().getContentlist();
            int allPages = bean.getShowapi_res_body().getAllPages();
            mJockView.onLoadSuccess(list, allPages);
        } else {
            JokeImgBean bean = (JokeImgBean) jokeBean;
            List<JokeImgBean.ShowapiResBodyBean.ContentlistBean> list = bean.getShowapi_res_body().getContentlist();
            int allPages = bean.getShowapi_res_body().getAllPages();
            mJockView.onLoadSuccess(list, allPages);
        }
        mJockView.hideProgress();
    }

    @Override
    public void onFail(Throwable e) {
        mJockView.onLoadFail();
        mJockView.hideProgress();
    }
}
