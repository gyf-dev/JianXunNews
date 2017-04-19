package com.gyf.jianxunnews.component;

import android.app.Activity;

import com.gyf.jianxunnews.module.ActivityModule;
import com.gyf.jianxunnews.module.PresenterModule;
import com.gyf.jianxunnews.ui.activity.TodayActivity;

import dagger.Component;

/**
 * Created by geyifeng on 2017/4/6.
 */

@ActivityScope
@Component(modules = {ActivityModule.class,PresenterModule.class}, dependencies = {AppComponent.class})
public interface ActivityComponent {

    Activity activity();

    void inject(TodayActivity todayActivity);
}
