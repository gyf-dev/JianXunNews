package com.gyf.jianxunnews.mvp.ui.fragment;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.jianxunnews.mvp.presenter.JokePresenter;
import com.gyf.jianxunnews.mvp.ui.adapter.JokeImgAdapter;

/**
 * Created by geyifeng on 2017/3/29.
 */

public class JokeGifFragment extends JokeBaseFragment {

    @Override
    protected JokePresenter initPresenter() {
        return new JokePresenter(JokePresenter.JokeType.GIFJOKE);
    }

    @Override
    protected void initAdapter() {
        mAdapter = new JokeImgAdapter();
    }

}
