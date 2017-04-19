package com.gyf.jianxunnews.ui.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gyf.jianxunnews.R;
import com.gyf.jianxunnews.model.bean.JokeImgBean.ShowapiResBodyBean.ContentlistBean;
import com.gyf.jianxunnews.utils.GlideUtils;

/**
 * Created by geyifeng on 2017/3/30.
 */

public class JokeImgAdapter extends BaseQuickAdapter<ContentlistBean, BaseViewHolder> {


    public JokeImgAdapter() {
        super(R.layout.item_joke_pic);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, ContentlistBean item) {
        viewHolder.setText(R.id.tv_joke_pic_title, item.getTitle());
        GlideUtils.load(item.getImg(), (ImageView) viewHolder.getView(R.id.iv_joke_pic));
    }
}
