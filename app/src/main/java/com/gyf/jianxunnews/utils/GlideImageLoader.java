package com.gyf.jianxunnews.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.gyf.jianxunnews.R;
import com.gyf.jianxunnews.app.MyApplication;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by geyifeng on 2017/5/3.
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context.getApplicationContext())
                .load(path)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.mipmap.glide)
                .into(imageView);
    }
}
