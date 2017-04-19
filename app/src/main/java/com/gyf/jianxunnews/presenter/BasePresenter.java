package com.gyf.jianxunnews.presenter;

import com.gyf.jianxunnews.component.DaggerPresenterComponent;
import com.gyf.jianxunnews.component.PresenterComponent;
import com.gyf.jianxunnews.module.PresenterModule;

/**
 * Created by geyifeng on 2017/4/12.
 */

public class BasePresenter {

    public static PresenterComponent presenterComponent;

    protected PresenterComponent getPresenterComponent() {
        presenterComponent = DaggerPresenterComponent.builder()
                .presenterModule(getPresenterModule())
                .build();
        return presenterComponent;
    }

    private PresenterModule getPresenterModule() {
        return new PresenterModule(this);
    }

}
