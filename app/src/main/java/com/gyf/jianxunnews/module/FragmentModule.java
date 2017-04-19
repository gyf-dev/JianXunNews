package com.gyf.jianxunnews.module;

import android.support.v4.app.Fragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by geyifeng on 2017/4/7.
 */

@Module
public class FragmentModule {

    private final Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    Fragment provideFragment() {
        return fragment;
    }
}
