package com.gyf.jianxunnews.dagger.component;

import android.app.Activity;

import com.gyf.jianxunnews.dagger.module.ActivityModule;
import com.gyf.jianxunnews.mvp.ui.activity.TodayActivity;

import dagger.Component;

/**
 * Created by geyifeng on 2017/4/6.
 */

@ActivityScope
@Component(modules = {ActivityModule.class}, dependencies = {AppComponent.class})
public interface ActivityComponent {

    Activity activity();

    void inject(TodayActivity todayActivity);
}
