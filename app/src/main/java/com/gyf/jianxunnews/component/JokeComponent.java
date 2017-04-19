package com.gyf.jianxunnews.component;

import com.gyf.jianxunnews.ui.fragment.JokeFragment;
import com.gyf.jianxunnews.ui.fragment.JokeGifFragment;
import com.gyf.jianxunnews.ui.fragment.JokePicFragment;
import com.gyf.jianxunnews.ui.fragment.JokeTextFragment;
import com.gyf.jianxunnews.module.JokeModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by geyifeng on 2017/4/5.
 */

@Singleton
@Component(modules = JokeModule.class)
public interface JokeComponent {
    void inject(JokeFragment fragment);
    void inject(JokeTextFragment fragment);
    void inject(JokePicFragment fragment);
    void inject(JokeGifFragment fragment);
}
