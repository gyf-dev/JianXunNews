package com.gyf.jianxunnews.module;

import com.gyf.jianxunnews.ui.fragment.HandpickFragment;
import com.gyf.jianxunnews.ui.fragment.JokeFragment;
import com.gyf.jianxunnews.ui.fragment.NewsFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by geyifeng on 2017/4/6.
 */

@Module
public class MainModule {
    @Singleton
    @Provides
    NewsFragment provideNewsFragment() {
        return new NewsFragment();
    }

    @Singleton
    @Provides
    JokeFragment provideJokeFragment() {
        return new JokeFragment();
    }

    @Singleton
    @Provides
    HandpickFragment provideHandpickFragment() {
        return new HandpickFragment();
    }
}
