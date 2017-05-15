package com.gyf.jianxunnews.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.gyf.jianxunnews.R;
import com.squareup.picasso.Picasso;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by geyifeng on 2017/5/3.
 */

public class PicassoImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Picasso.with(context.getApplicationContext())
                .load(String.valueOf(path))
                .placeholder(R.mipmap.glide)
                .into(imageView);
    }
}
