package com.gyf.jianxunnews.module;

import com.gyf.jianxunnews.ui.fragment.JokeGifFragment;
import com.gyf.jianxunnews.ui.fragment.JokePicFragment;
import com.gyf.jianxunnews.ui.fragment.JokeTextFragment;
import com.gyf.jianxunnews.ui.view.IBaseView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by geyifeng on 2017/4/5.
 */

@Module
public class JokeModule {
    private IBaseView mView;
    private int type;

    @Singleton
    public JokeModule() {
    }

    @Singleton
    public JokeModule(IBaseView view, int type) {
        this.mView = view;
        this.type = type;
    }

    @Provides
    IBaseView provideJockView() {
        return mView;
    }

    @Provides
    int provideType() {
        return type;
    }

    @Singleton
    @Provides
    JokeTextFragment provideJokeTextFragment() {
        return new JokeTextFragment();
    }

    @Singleton
    @Provides
    JokePicFragment provideJokePicFragment() {
        return new JokePicFragment();
    }

    @Singleton
    @Provides
    JokeGifFragment provideJokeGifFragment() {
        return new JokeGifFragment();
    }
}
