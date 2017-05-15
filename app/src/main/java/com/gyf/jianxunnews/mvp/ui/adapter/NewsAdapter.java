package com.gyf.jianxunnews.mvp.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.apkfuns.logutils.LogUtils;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gyf.jianxunnews.R;
import com.gyf.jianxunnews.mvp.model.bean.NewsBean;
import com.gyf.jianxunnews.utils.GlideImageLoader;
import com.gyf.jianxunnews.utils.GlideUtils;
import com.gyf.jianxunnews.utils.StringUtil;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by geyifeng on 2017/5/3.
 */

public class NewsAdapter extends BaseMultiItemQuickAdapter<NewsBean, BaseViewHolder> {

    public NewsAdapter() {
        super(new ArrayList<NewsBean>());
        addItemType(NewsBean.NEWS_SLIDESHOW, R.layout.item_empty);
        addItemType(NewsBean.NEWS_ONE_PIC, R.layout.item_news_one);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, NewsBean item) {
        switch (viewHolder.getItemViewType()) {
            case NewsBean.NEWS_ONE_PIC:
                ImageView iv_news_icon = viewHolder.getView(R.id.iv_news_icon);
                String pic = item.getPic();
                viewHolder.setText(R.id.tv_news_title, item.getTitle())
                        .setText(R.id.tv_news_src, item.getSrc())
                        .setText(R.id.tv_news_time, item.getTime());
                if (StringUtil.isEmpty(pic)) {
                    iv_news_icon.setVisibility(View.GONE);
                } else {
                    iv_news_icon.setVisibility(View.VISIBLE);
                    Picasso.with(mContext)
                            .load(item.getPic())
                            .placeholder(R.mipmap.glide)
                            .error(R.mipmap.glide)
                            .into(iv_news_icon);
                    //           GlideUtils.load2(item.getPic(), iv_news_icon);
                }
                break;
        }
    }
}
