package com.gyf.jianxunnews.module;

import android.app.Application;
import android.content.Context;

import com.gyf.jianxunnews.app.MyApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by geyifeng on 2017/4/6.
 */

@Module
public class AppModule {

    private final MyApplication application;

    public AppModule(Application application) {
        this.application = (MyApplication) application;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return application;
    }
}
