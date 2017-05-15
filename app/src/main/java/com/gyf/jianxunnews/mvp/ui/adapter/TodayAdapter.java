package com.gyf.jianxunnews.mvp.ui.adapter;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gyf.jianxunnews.R;
import com.gyf.jianxunnews.mvp.model.bean.TodayBean;
import com.gyf.jianxunnews.utils.GlideUtils;

/**
 * Created by geyifeng on 2017/4/11.
 */

public class TodayAdapter extends BaseQuickAdapter<TodayBean.ListBean, BaseViewHolder> {
    public TodayAdapter() {
        super(R.layout.item_today);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, TodayBean.ListBean item) {
        String imgUrl = item.getImg();
        ImageView iv_pic = viewHolder.getView(R.id.iv_pic);
        if (imgUrl != null) {
            iv_pic.setVisibility(View.VISIBLE);
            GlideUtils.load(imgUrl, iv_pic);
        } else {
            iv_pic.setVisibility(View.GONE);
        }

        viewHolder.setText(R.id.tv_time, item.getYear() + "-" + item.getMonth() + "-" + item.getDay())
                .setText(R.id.tv_title, item.getTitle());
    }
}
