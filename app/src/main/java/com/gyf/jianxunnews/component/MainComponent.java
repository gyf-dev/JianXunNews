package com.gyf.jianxunnews.component;

import com.gyf.jianxunnews.module.MainModule;
import com.gyf.jianxunnews.ui.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by geyifeng on 2017/4/5.
 */

@Singleton
@Component(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity activity);
}
