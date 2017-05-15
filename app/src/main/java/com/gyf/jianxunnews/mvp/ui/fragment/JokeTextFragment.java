package com.gyf.jianxunnews.mvp.ui.fragment;

import com.gyf.jianxunnews.mvp.presenter.JokePresenter;
import com.gyf.jianxunnews.mvp.ui.adapter.JokeTextAdapter;

/**
 * Created by geyifeng on 2017/3/29.
 */

public class JokeTextFragment extends JokeBaseFragment {

    @Override
    protected JokePresenter initPresenter() {
        return new JokePresenter(JokePresenter.JokeType.TEXTJOKE);
    }

    @Override
    protected void initAdapter() {
        mAdapter = new JokeTextAdapter();
    }

}
