package com.gyf.jianxunnews.component;

import android.support.v4.app.Fragment;

import com.gyf.jianxunnews.module.FragmentModule;

import dagger.Component;

/**
 * Created by geyifeng on 2017/4/7.
 */

@Component(modules = FragmentModule.class)
public interface FragmentComponent {
    Fragment fragment();
}
