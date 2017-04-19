package com.gyf.jianxunnews.module;

import android.app.Activity;

import com.gyf.jianxunnews.component.ActivityScope;
import com.gyf.jianxunnews.presenter.TodayPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by geyifeng on 2017/4/6.
 */

@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @ActivityScope
    @Provides
    Activity provideActivity() {
        return activity;
    }

}
