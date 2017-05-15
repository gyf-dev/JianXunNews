package com.gyf.jianxunnews.dagger.module;

import android.app.Activity;


import com.gyf.jianxunnews.dagger.component.ActivityScope;

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
