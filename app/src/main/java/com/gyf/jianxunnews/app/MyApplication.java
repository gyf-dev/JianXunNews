package com.gyf.jianxunnews.app;

import android.app.Application;

import com.gyf.jianxunnews.dagger.component.AppComponent;

import cn.bingoogolapple.swipebacklayout.BGASwipeBackManager;


/**
 * Created by geyifeng on 2017/4/1.
 */

public class MyApplication extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initApplication();
        BGASwipeBackManager.getInstance().init(this);
    }

    private void initApplication() {
        appComponent = AppComponent.Initializer.init(this);
        appComponent.inject(this);
    }

    public static AppComponent getComponent() {
        return appComponent;
    }
}
