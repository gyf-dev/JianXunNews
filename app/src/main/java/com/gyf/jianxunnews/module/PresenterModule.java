package com.gyf.jianxunnews.module;

import com.gyf.jianxunnews.presenter.BasePresenter;
import com.gyf.jianxunnews.presenter.TodayPresenter;
import com.gyf.jianxunnews.ui.view.IBaseView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by geyifeng on 2017/4/12.
 */

@Module
public class PresenterModule {

    private final BasePresenter presenter;

    @Singleton
    public PresenterModule(BasePresenter presenter) {
        this.presenter = presenter;
    }

    @Provides
    BasePresenter provideBasePresenter() {
        return presenter;
    }

    @Provides
    TodayPresenter provideTodayPresenter(IBaseView baseView){
        return new TodayPresenter(baseView);
    }

}
