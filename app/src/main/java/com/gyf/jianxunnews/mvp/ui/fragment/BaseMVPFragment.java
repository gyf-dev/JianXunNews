package com.gyf.jianxunnews.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gyf.jianxunnews.mvp.presenter.BasePresenter;

/**
 * Created by geyifeng on 2017/5/2.
 */

public abstract class BaseMVPFragment<V,T extends BasePresenter<V>> extends BaseFragment {
    public T mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPresenter = initPresenter();
        mPresenter.attachView((V)this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //mPresenter.dettachView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.dettachView();
    }

    protected abstract T initPresenter();
}
