package com.gyf.jianxunnews.mvp.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.jianxunnews.R;
import com.gyf.jianxunnews.mvp.model.bean.JokeBean;
import com.gyf.jianxunnews.mvp.presenter.JokePresenter;
import com.gyf.jianxunnews.mvp.ui.adapter.JokeAdapter;
import com.gyf.jianxunnews.mvp.ui.view.JokeView;
import com.gyf.jianxunnews.view.LoadView;

import java.util.List;

import butterknife.BindView;

/**
 * Created by geyifeng on 2017/4/2.
 */

public abstract class JokeBaseFragment extends BaseMVPFragment<JokeView, JokePresenter> implements JokeView
        , BaseQuickAdapter.RequestLoadMoreListener
        , LoadView.OnLoadClickListener
        , SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.rv_parent)
    RecyclerView mRv_parent;
    @BindView(R.id.load_view)
    LoadView mLoadView;
    @BindView(R.id.refresh)
    SwipeRefreshLayout mRefresh;

    protected JokeAdapter mAdapter;
    protected boolean isRefresh = false;

    protected int allPages;
    protected int page = 1;

    @Override
    protected int setLayoutId() {
        return R.layout.recycler_view_parent;
    }

    @Override
    protected void initView() {
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        mRv_parent.setLayoutManager(linearLayoutManager);
        initAdapter();
        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        mRv_parent.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        mPresenter.onLoad(String.valueOf(page));
    }

    @Override
    protected void setListener() {
        mLoadView.setOnLoadCliCkListener(this);
        mRefresh.setOnRefreshListener(this);
        mAdapter.setOnLoadMoreListener(this, mRv_parent);
    }

    @Override
    public void onRefresh() {
        isRefresh = true;
        page = 1;
        mPresenter.onLoad(String.valueOf(page));
    }

    @Override
    public void onLoadMoreRequested() {
        if (page < allPages) {
            mPresenter.onLoad(String.valueOf(page));
        } else {
            mAdapter.loadMoreEnd();
        }

    }

    @Override
    public void showProgress() {
        if (page == 1 && !isRefresh) {
            mLoadView.setCurrentStatus(LoadView.LOAD_LOADING);
            mRv_parent.setVisibility(View.GONE);
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
        mPresenter.onLoad(String.valueOf(page));
    }

    @Override
    public void onLoadSuccess(List<JokeBean.ListBean> list, int allPages) {
        if(isRefresh){
            mAdapter.setNewData(list);
        }else {
            mAdapter.addData(list);
        }
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

    protected abstract void initAdapter();

}
