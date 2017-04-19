package com.gyf.jianxunnews.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.jianxunnews.R;
import com.gyf.jianxunnews.ui.LoadView;
import com.gyf.jianxunnews.ui.view.IBaseView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by geyifeng on 2017/4/2.
 */

public abstract class JokeBaseFragment<T> extends BaseFragment implements IBaseView<T>
        , BaseQuickAdapter.RequestLoadMoreListener
        , LoadView.OnLoadClickListener
        , SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.rv_parent)
    RecyclerView mRv_parent;
    @BindView(R.id.load_view)
    LoadView mLoadView;
    @BindView(R.id.refresh)
    SwipeRefreshLayout mRefresh;

    public static final String MAX_NUM = "20";
    public int allPages;
    public int page = 1;

    @Override
    protected int setLayoutResource() {
        return R.layout.fragment_parent;
    }

    @Override
    protected void initView() {
        //isLazyLoad(false);
        ButterKnife.bind(this, mRootView);
        initAdapter();
    }


    protected abstract void initAdapter();
}
