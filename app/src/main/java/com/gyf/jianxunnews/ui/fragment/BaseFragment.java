package com.gyf.jianxunnews.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apkfuns.logutils.LogUtils;

import butterknife.ButterKnife;

/**
 * Created by geyifeng on 2017/4/2.
 */

public abstract class BaseFragment extends Fragment {

    protected FragmentActivity mActivity;

    /**
     * 是否对用户可见
     */
    protected boolean mIsVisible;
    /**
     * 是否加载完成
     * 当执行完oncreatview,View的初始化方法后方法后即为true
     */
    protected boolean mIsPrepare;

    private boolean mIsLazyLoad = true;

    protected View mRootView;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = getActivity();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (getUserVisibleHint()) {
            mIsVisible = true;
            onVisible();
        } else {
            mIsVisible = false;
            onInvisible();
        }

    }

    protected void isLazyLoad(boolean isLazyLoad) {
        this.mIsLazyLoad = isLazyLoad;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(setLayoutResource(), null);
        initView();
        mIsPrepare = true;
        if (mIsLazyLoad) {
            onLazyLoad();
        } else {
            initData();
        }
        setListener();
        return mRootView;
    }


    /**
     * 用户可见时执行的操作
     */
    protected void onVisible() {
        onLazyLoad();
    }

    private void onLazyLoad() {

        if (mIsVisible & mIsPrepare) {
            mIsPrepare = false;
            initData();
        }

    }

    protected abstract int setLayoutResource();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void setListener();

    protected void onInvisible() {
    }

}
