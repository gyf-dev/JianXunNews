package com.gyf.jianxunnews.mvp.ui.activity;

import android.os.Bundle;

import com.gyf.jianxunnews.mvp.presenter.BasePresenter;

/**
 * Created by geyifeng on 2017/4/27.
 */

public abstract class BaseMVPActivity<V,T extends BasePresenter<V>> extends BaseActivity {
    public T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mPresenter = initPresenter();
        mPresenter.attachView((V)this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.dettachView();
    }

    // 实例化presenter
    public abstract T initPresenter();
}
