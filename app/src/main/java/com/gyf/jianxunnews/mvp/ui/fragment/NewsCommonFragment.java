package com.gyf.jianxunnews.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.apkfuns.logutils.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.gyf.jianxunnews.R;
import com.gyf.jianxunnews.mvp.model.bean.NewsBean;
import com.gyf.jianxunnews.mvp.model.bean.NewsMultipleItem;
import com.gyf.jianxunnews.mvp.presenter.NewsPresenter;
import com.gyf.jianxunnews.mvp.ui.activity.NewsDetailsActivity;
import com.gyf.jianxunnews.mvp.ui.adapter.NewsAdapter;
import com.gyf.jianxunnews.mvp.ui.view.NewsView;
import com.gyf.jianxunnews.utils.GlideImageLoader;
import com.gyf.jianxunnews.utils.PicassoImageLoader;
import com.gyf.jianxunnews.view.LoadView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import butterknife.BindView;

/**
 * Created by geyifeng on 2017/5/2.
 */

public class NewsCommonFragment extends BaseMVPFragment<NewsView, NewsPresenter> implements NewsView
        , BaseQuickAdapter.RequestLoadMoreListener
        , SwipeRefreshLayout.OnRefreshListener
        , BaseQuickAdapter.OnItemClickListener, OnBannerListener
        , LoadView.OnLoadClickListener {

    @BindView(R.id.rv_parent)
    RecyclerView mRv_parent;
    @BindView(R.id.load_view)
    LoadView mLoadView;
    @BindView(R.id.refresh)
    SwipeRefreshLayout mRefresh;

    private int page;
    private NewsAdapter mAdapter;
    private String channel;
    protected boolean isRefresh = false;
    private View headView;
    private List<NewsBean> mSlideShowList = new ArrayList<>();

    private static final String CHANNEL = "channel";

    public NewsCommonFragment() {
    }

    public NewsCommonFragment(String channel) {
        this.channel = channel;
    }

    public static NewsCommonFragment newInstance(String channel) {
        NewsCommonFragment newInstance = new NewsCommonFragment(channel);
        Bundle bundle = new Bundle(1);
        bundle.putString(CHANNEL, channel);
        newInstance.setArguments(bundle);
        return newInstance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        channel = getArguments().getString(CHANNEL);
    }

    @Override
    protected NewsPresenter initPresenter() {
        return new NewsPresenter();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.recycler_view_parent;
    }

    @Override
    protected void initView() {
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        mRv_parent.setLayoutManager(linearLayoutManager);
        mAdapter = new NewsAdapter();
        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        mRv_parent.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        page = 0;
        mPresenter.load(channel, String.valueOf(page));
    }

    @Override
    protected void setListener() {
        mRefresh.setOnRefreshListener(this);
        mAdapter.setOnLoadMoreListener(this, mRv_parent);
        mAdapter.setOnItemClickListener(this);
        mLoadView.setOnLoadCliCkListener(this);
    }

    @Override
    public void showProgress() {
        if (page == 0 && !isRefresh) {
            mLoadView.setCurrentStatus(LoadView.LOAD_LOADING);
            mRv_parent.setVisibility(View.GONE);
        }
    }

    @Override
    public void hideProgress() {
        if (page > 0) {
            mLoadView.setCurrentStatus(LoadView.LOAD_SUCCESS);
            mRv_parent.setVisibility(View.VISIBLE);
        }
        if (isRefresh) {
            isRefresh = false;
            mRefresh.setRefreshing(false);
        }
    }

    @Override
    public void onLoadSuccess(List<NewsBean> newsBeanList) {
        if (isRefresh) {
            mAdapter.setNewData(newsBeanList);
        } else {
            mAdapter.addData(newsBeanList);
        }
        if (page == 0) {
            mAdapter.removeHeaderView(headView);
            addHeader(newsBeanList);
        }
        mAdapter.loadMoreComplete();
        page = mAdapter.getData().size();
    }

    @Override
    public void onLoadFail() {
        if (page > 0) {
            mAdapter.loadMoreFail();
        } else {
            mRv_parent.setVisibility(View.GONE);
            mLoadView.setCurrentStatus(LoadView.LOAD_EMPTY);
        }
    }

    @Override
    public void onLoadMoreRequested() {
        mPresenter.load(channel, String.valueOf(page));
    }

    @Override
    public void onRefresh() {
        isRefresh = true;
        page = 0;
        mPresenter.load(channel, String.valueOf(page));
    }

    @Override
    public void onFailClick() {
        mPresenter.load(channel, String.valueOf(page));
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        NewsBean item = (NewsBean) adapter.getData().get(position);
        toActivity(item);
    }

    private void addHeader(List<NewsBean> newsBeanList) {
        ArrayList<String> images = new ArrayList<>();
        ArrayList<String> titles = new ArrayList<>();
        mSlideShowList = new ArrayList<>();
        for (int i = 0; i < newsBeanList.size(); i++) {
            if (newsBeanList.get(i).getItemType() == NewsBean.NEWS_SLIDESHOW) {
                mSlideShowList.add(newsBeanList.get(i));
                images.add(newsBeanList.get(i).getPic());
                titles.add(newsBeanList.get(i).getTitle());
            }
        }
        if (newsBeanList.size() > 0) {
            headView = LayoutInflater.from(mActivity).inflate(R.layout.item_slideshow, (ViewGroup) mRv_parent.getParent(), false);
            Banner banner = (Banner) headView.findViewById(R.id.banner_slideshow);
            banner.setImages(images)
                    .setBannerTitles(titles)
                    .setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE)
                    .setImageLoader(new PicassoImageLoader())
                    .setDelayTime(5000)
                    .start();
            banner.setOnBannerListener(this);
            mAdapter.addHeaderView(headView);
        }
    }

    @Override
    public void OnBannerClick(int position) {
        toActivity(mSlideShowList.get(position));
    }

    private void toActivity(NewsBean bean) {
        Intent intent = new Intent(mActivity, NewsDetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("news_details", bean);
        intent.putExtras(bundle);
        mActivity.startActivity(intent);
    }

}
