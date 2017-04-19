package com.gyf.jianxunnews.component;

import android.app.Application;
import android.content.Context;

import com.gyf.jianxunnews.app.MyApplication;
import com.gyf.jianxunnews.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by geyifeng on 2017/4/6.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(Application application);

    Context context();

    final class Initializer {
        public static AppComponent init(Application application) {
            return DaggerAppComponent.builder()
                    .appModule(new AppModule((MyApplication) application))
                    .build();
        }
    }
}
