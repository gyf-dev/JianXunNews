package com.gyf.jianxunnews.ui.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.apkfuns.logutils.LogUtils;
import com.gyf.jianxunnews.R;
import com.gyf.jianxunnews.model.bean.TodayBean;
import com.gyf.jianxunnews.presenter.TodayPresenter;
import com.gyf.jianxunnews.ui.LoadView;
import com.gyf.jianxunnews.ui.TitleView;
import com.gyf.jianxunnews.ui.view.IBaseView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * 那年今日
 * Created by geyifeng on 2017/4/7.
 */

public class TodayActivity extends BaseActivity implements TitleView.OnItemClickListener ,IBaseView<TodayBean.ShowapiResBodyBean.ListBean>{

    @BindView(R.id.title_view)
    TitleView mTitleView;
    @BindView(R.id.rv_parent)
    RecyclerView mRv_parent;
    @BindView(R.id.load_view)
    LoadView mLoadView;
    @BindView(R.id.refresh)
    SwipeRefreshLayout mRefresh;

//    @Inject
//    TodayPresenter mPresenter;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_today;
    }

    @Override
    protected void initView() {
        getActivityComponent().inject(this);
        new TodayPresenter(this);
        //LogUtils.d(mPresenter == null);
    }


    @Override
    protected void setListener() {
        mTitleView.setOnItemClickListener(this);
    }

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

    @Override
    public void showProgress() {

    }

    @Override
    public void onLoadSuccess(List<TodayBean.ShowapiResBodyBean.ListBean> list, int allPages) {

    }

    @Override
    public void onLoadFail() {

    }

    @Override
    public void hideProgress() {

    }
}
