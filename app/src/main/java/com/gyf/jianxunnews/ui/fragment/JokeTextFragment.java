package com.gyf.jianxunnews.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.apkfuns.logutils.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.jianxunnews.ui.adapter.JokeTextAdapter;
import com.gyf.jianxunnews.component.DaggerJokeComponent;
import com.gyf.jianxunnews.model.bean.JokeTextBean;
import com.gyf.jianxunnews.presenter.JokePresenter;
import com.gyf.jianxunnews.ui.LoadView;
import com.gyf.jianxunnews.module.JokeModule;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by geyifeng on 2017/3/29.
 */

public class JokeTextFragment extends JokeBaseFragment<JokeTextBean.ShowapiResBodyBean.ContentlistBean> {

    @Inject
    JokePresenter mPresenter;
    private JokeTextAdapter mAdapter;

    private boolean isRefresh = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerJokeComponent.builder()
                .jokeModule(new JokeModule(this, 1))
                .build()
                .inject(this);
    }

    @Override
    protected void initAdapter() {
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        mRv_parent.setLayoutManager(linearLayoutManager);
        mAdapter = new JokeTextAdapter();
        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        mRv_parent.setAdapter(mAdapter);
    }

    @Override
    protected void setListener() {
        mAdapter.setOnLoadMoreListener(this, mRv_parent);
        mLoadView.setOnLoadCliCkListener(this);
        mRefresh.setOnRefreshListener(this);
    }

    @Override
    protected void initData() {
        LogUtils.d("JokeTextFragment");
        mPresenter.loadJoke(MAX_NUM, String.valueOf(page));
    }

    @Override
    public void onRefresh() {
        isRefresh = true;
        page = 1;
        mPresenter.loadJoke(MAX_NUM, String.valueOf(page));
    }

    @Override
    public void onLoadMoreRequested() {
        if (page < allPages) {
            mPresenter.loadJoke(MAX_NUM, String.valueOf(page));
        } else {
            mAdapter.loadMoreEnd();
        }

    }

    @Override
    public void showProgress() {
        if (page == 1) {
            mLoadView.setCurrentStatus(LoadView.LOAD_LOADING);
            mRv_parent.setVisibility(View.GONE);
        }
    }

    @Override
    public void onLoadSuccess(List<JokeTextBean.ShowapiResBodyBean.ContentlistBean> list, int allPages) {
        mAdapter.addData(list);
        mAdapter.loadMoreComplete();
        this.allPages = allPages;
        page++;
    }

    @Override
    public void onLoadFail() {
        if (page >= 2) {
            mAdapter.loadMoreFail();
        } else {
            mLoadView.setCurrentStatus(LoadView.LOAD_FAIL);
        }
    }

    @Override
    public void hideProgress() {
        if (page == 2) {
            mLoadView.setCurrentStatus(LoadView.LOAD_SUCCESS);
            mRv_parent.setVisibility(View.VISIBLE);
        }
        if (isRefresh) {
            isRefresh = false;
            mRefresh.setRefreshing(false);
        }
    }

    @Override
    public void onFailClick() {
        mPresenter.loadJoke(MAX_NUM, String.valueOf(page));
    }
}
