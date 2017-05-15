package com.gyf.jianxunnews.mvp.ui.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.apkfuns.logutils.LogUtils;
import com.gyf.barlibrary.ImmersionBar;
import com.gyf.jianxunnews.R;
import com.gyf.jianxunnews.mvp.model.bean.TodayBean;
import com.gyf.jianxunnews.mvp.presenter.TodayPresenter;
import com.gyf.jianxunnews.mvp.ui.adapter.TodayAdapter;
import com.gyf.jianxunnews.mvp.ui.view.TodayView;
import com.gyf.jianxunnews.view.LoadView;
import com.gyf.jianxunnews.view.TitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

/**
 * Created by geyifeng on 2017/4/27.
 */

public class TodayActivity extends BaseMVPActivity<TodayView, TodayPresenter> implements TodayView, LoadView.OnLoadClickListener {

    @BindView(R.id.title_view)
    TitleView mTitleView;
    @BindView(R.id.rv_parent)
    RecyclerView mRv_parent;
    @BindView(R.id.load_view)
    LoadView mLoadView;
    @BindView(R.id.refresh)
    SwipeRefreshLayout mRefresh;
    private TodayAdapter mAdapter;
    private ArrayList<TodayBean.ListBean> listBeen = new ArrayList<>();

    @Override
    public TodayPresenter initPresenter() {
        return new TodayPresenter();
    }

    @Override
    protected int setLayoutId() {
        ImmersionBar.with(this).init();
        return R.layout.activity_today;
    }

    @Override
    protected void initView() {
        mRefresh.setEnabled(false);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        mRv_parent.setLayoutManager(linearLayoutManager);
        OverScrollDecoratorHelper.setUpOverScroll(mRv_parent, OverScrollDecoratorHelper.ORIENTATION_VERTICAL);
        mAdapter = new TodayAdapter();
        mRv_parent.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        mPresenter.load();
    }

    @Override
    protected void setListener() {
        mTitleView.setOnItemClickListener(new TitleView.OnItemClickListener() {
            @Override
            public void onLeftClick() {
                finish();
            }

            @Override
            public void onRightClick() {

            }

            @Override
            public void onMiddleClick() {

            }
        });
    }

    @Override
    public void showProgress() {
        mLoadView.setCurrentStatus(LoadView.LOAD_LOADING);
        mRv_parent.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        if (!listBeen.isEmpty() && listBeen != null) {
            mLoadView.setCurrentStatus(LoadView.LOAD_SUCCESS);
            mRv_parent.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onLoadSuccess(List<TodayBean.ListBean> list) {
        listBeen.addAll(list);
        mAdapter.addData(list);
    }

    @Override
    public void onLoadFail() {
        mLoadView.setCurrentStatus(LoadView.LOAD_FAIL);
    }

    @Override
    public void onFailClick() {
        mPresenter.load();
    }

    @Override
    public boolean isSupportSwipeBack() {
        return true;
    }
}
