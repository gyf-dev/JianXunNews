package com.gyf.jianxunnews.view;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.gyf.jianxunnews.R;

/**
 * Created by geyifeng on 2017/3/31.
 */

public class LoadView extends FrameLayout {

    public final static int LOAD_UNDO = 1;
    public final static int LOAD_LOADING = 2;
    public final static int LOAD_FAIL = 3;
    public final static int LOAD_EMPTY = 4;
    public final static int LOAD_SUCCESS = 5;

    private int CURRENT_STATUS = LOAD_UNDO;

    private Context context;
    private ProgressBar mProgressBar;
    private Button mFail;
    private Button mEmpty;
    private View mLoading;

    public LoadView(@NonNull Context context) {
        super(context);
        this.context = context;
        init();
    }

    public LoadView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public LoadView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        mLoading = LayoutInflater.from(context).inflate(R.layout.loading, null);
        mProgressBar = (ProgressBar) mLoading.findViewById(R.id.ps_loading);
        mFail = (Button) mLoading.findViewById(R.id.btn_fail);
        mEmpty = (Button) mLoading.findViewById(R.id.btn_empty);
        addView(mLoading);
        showView();
    }

    private void showView() {
        mProgressBar.setVisibility((CURRENT_STATUS == LOAD_UNDO || CURRENT_STATUS == LOAD_LOADING)
                ? VISIBLE : GONE);
        mFail.setVisibility(CURRENT_STATUS == LOAD_FAIL ? VISIBLE : GONE);
        mEmpty.setVisibility(CURRENT_STATUS == LOAD_EMPTY ? VISIBLE : GONE);
        mLoading.setVisibility(CURRENT_STATUS == LOAD_SUCCESS ? GONE : VISIBLE);

    }

    public void setCurrentStatus(int status) {
        CURRENT_STATUS = status;
        showView();
    }
    public int getCurrentStatus() {
        return CURRENT_STATUS;
    }

    public void setOnLoadCliCkListener(final OnLoadClickListener listener) {
        mFail.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setCurrentStatus(LOAD_LOADING);
                listener.onFailClick();
            }
        });
        mEmpty.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setCurrentStatus(LOAD_LOADING);
                listener.onFailClick();
            }
        });
    }

    public interface OnLoadClickListener {
        void onFailClick();
    }
}
