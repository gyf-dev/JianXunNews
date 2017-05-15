package com.gyf.jianxunnews.mvp.presenter;

import com.apkfuns.logutils.LogUtils;
import com.gyf.jianxunnews.mvp.model.INewsModel;
import com.gyf.jianxunnews.mvp.model.NewsModel;
import com.gyf.jianxunnews.mvp.model.bean.NewsBean;
import com.gyf.jianxunnews.mvp.model.bean.NewsStatusBean;
import com.gyf.jianxunnews.mvp.model.listener.OnLoadListener;
import com.gyf.jianxunnews.mvp.ui.view.NewsView;
import com.gyf.jianxunnews.utils.StringUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by geyifeng on 2017/5/3.
 */

public class NewsPresenter extends BasePresenter<NewsView> implements INewsPresenter,
        OnLoadListener<NewsStatusBean.NewsResultBean> {

    private final static String MAX_NUM = "20";
    private Map<String, String> mNewsMap = new HashMap<>();
    private INewsModel mNewsModel;
    private int page;

    public NewsPresenter() {
        mNewsModel = new NewsModel();
    }

    @Override
    public void load(String channel, String page) {
        this.page = Integer.parseInt(page);
        mNewsMap.clear();
        mNewsMap.put("channel", channel);
        if (Integer.parseInt(page) == 0)
            mNewsMap.put("num", "25");
        else
            mNewsMap.put("num", MAX_NUM);
        mNewsMap.put("start", page);
        mNewsModel.load(mNewsMap, this);
        if (this.page == 0) {
            mView.showProgress();
        }
    }


    @Override
    public void onSuccess(NewsStatusBean.NewsResultBean data) {
        List<NewsBean> newsBeanList = data.getList();
        int flag = 0;
        for (int i = 0; i < newsBeanList.size(); i++) {
            String pic = newsBeanList.get(i).getPic();
            if (page == 0) {
                if (!StringUtil.isEmpty(pic)) {
                    if (flag <= 4) {
                        newsBeanList.get(i).setItemType(NewsBean.NEWS_SLIDESHOW);
                        flag++;
                    } else {
                        newsBeanList.get(i).setItemType(NewsBean.NEWS_ONE_PIC);
                    }
                } else {
                    newsBeanList.get(i).setItemType(NewsBean.NEWS_ONE_PIC);
                }
            } else {
                newsBeanList.get(i).setItemType(NewsBean.NEWS_ONE_PIC);
            }
        }
        mView.onLoadSuccess(newsBeanList);
        mView.hideProgress();
    }

    @Override
    public void onFail(Throwable e) {
        mView.onLoadFail();
        mView.hideProgress();
    }
}
