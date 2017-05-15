package com.gyf.jianxunnews.mvp.ui.adapter;

import com.chad.library.adapter.base.BaseViewHolder;
import com.gyf.jianxunnews.R;
import com.gyf.jianxunnews.mvp.model.bean.JokeBean;

/**
 * Created by geyifeng on 2017/3/30.
 */

public class JokeTextAdapter extends JokeAdapter {


    public JokeTextAdapter() {
        super(R.layout.item_joke_text);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, JokeBean.ListBean item) {
        viewHolder.setText(R.id.tv_joke_text,item.getText());
    }
}
