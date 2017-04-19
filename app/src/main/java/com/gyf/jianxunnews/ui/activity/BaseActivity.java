package com.gyf.jianxunnews.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gyf.barlibrary.BarManager;
import com.gyf.jianxunnews.app.MyApplication;
import com.gyf.jianxunnews.component.ActivityComponent;
import com.gyf.jianxunnews.component.DaggerActivityComponent;
import com.gyf.jianxunnews.module.ActivityModule;
import com.gyf.jianxunnews.module.PresenterModule;
import com.gyf.jianxunnews.presenter.BasePresenter;

import butterknife.ButterKnife;

/**
 * Created by geyifeng on 2017/4/6.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        BarManager.setBarColor(this);
        ButterKnife.bind(this);
        initView();
        initData();
        setListener();
    }

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(MyApplication.getComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    protected abstract int setLayoutId();

    protected abstract void initView();

    protected void initData() {
    }

    protected void setListener() {
    }
}
