package com.gyf.jianxunnews.dagger.component;

import android.support.v4.app.Fragment;


import com.gyf.jianxunnews.dagger.module.FragmentModule;

import dagger.Component;

/**
 * Created by geyifeng on 2017/4/7.
 */

@Component(modules = FragmentModule.class)
public interface FragmentComponent {
    Fragment fragment();
}
