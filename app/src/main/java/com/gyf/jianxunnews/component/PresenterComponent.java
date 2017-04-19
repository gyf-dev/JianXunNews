package com.gyf.jianxunnews.component;

import com.gyf.jianxunnews.module.PresenterModule;
import com.gyf.jianxunnews.presenter.BasePresenter;
import com.gyf.jianxunnews.presenter.TodayPresenter;

import dagger.Component;

/**
 * Created by geyifeng on 2017/4/12.
 */

@Component(modules = PresenterModule.class)
public interface PresenterComponent {
    BasePresenter presenter();
    void inject(TodayPresenter todayPresenter);
}
