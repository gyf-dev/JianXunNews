package com.gyf.jianxunnews.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gyf.jianxunnews.R;
import com.gyf.jianxunnews.model.bean.JokeTextBean.ShowapiResBodyBean.*;

/**
 * Created by geyifeng on 2017/3/30.
 */

public class JokeTextAdapter extends BaseQuickAdapter<ContentlistBean,BaseViewHolder> {


    public JokeTextAdapter() {
        super(R.layout.item_joke_text);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, ContentlistBean item) {
        viewHolder.setText(R.id.tv_joke_text,item.getText());
    }
}
