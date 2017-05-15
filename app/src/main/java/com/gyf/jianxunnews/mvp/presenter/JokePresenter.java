package com.gyf.jianxunnews.mvp.presenter;

import com.gyf.jianxunnews.mvp.model.IJokeModel;
import com.gyf.jianxunnews.mvp.model.JokeModel;
import com.gyf.jianxunnews.mvp.model.bean.JokeBean;
import com.gyf.jianxunnews.mvp.model.listener.OnLoadListener;
import com.gyf.jianxunnews.mvp.ui.view.JokeView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by geyifeng on 2017/3/30.
 */

public class JokePresenter extends BasePresenter<JokeView> implements IJokePresenter, OnLoadListener<JokeBean> {

   // private JokeView mJockView;
    private IJokeModel mJokeModel;
    private String type;

    private static final String MAX_NUM = "20";

    public JokePresenter(JokeType jokeType) {
      //  this.mJockView = jockView;
        mJokeModel = new JokeModel();
        type = jokeType.getType();
    }

    @Override
    public void onLoad(String page) {
        Map<String, String> map = new HashMap<>();
        map.put("maxResult", MAX_NUM);
        map.put("page", page);
        map.put("time", "2016-07-01");
        mView.showProgress();
        mJokeModel.onLoad(type,map,this);
    }


    @SuppressWarnings("unchecked")
    @Override
    public void onSuccess(JokeBean jokeBean) {
        mView.onLoadSuccess(jokeBean.getContentlist(), jokeBean.getAllPages());
        mView.hideProgress();
    }

    @Override
    public void onFail(Throwable e) {
        mView.onLoadFail();
        mView.hideProgress();
    }

    public enum JokeType{
        TEXTJOKE("textJoke"), PICJOKE("picJoke"), GIFJOKE("gifJoke");

        String jokeType;
        JokeType(String jokeType) {
            this.jokeType = jokeType;
        }

        public String getType() {
            return jokeType;
        }
    }
}
