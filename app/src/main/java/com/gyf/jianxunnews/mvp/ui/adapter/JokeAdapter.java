package com.gyf.jianxunnews.mvp.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gyf.jianxunnews.mvp.model.bean.JokeBean;

/**
 * Created by geyifeng on 2017/4/27.
 */

public abstract class JokeAdapter extends BaseQuickAdapter<JokeBean.ListBean,BaseViewHolder> {

    public JokeAdapter(int layoutResId) {
        super(layoutResId);
    }
}
