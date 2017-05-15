package com.gyf.jianxunnews.utils;

import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.gyf.jianxunnews.R;
import com.gyf.jianxunnews.app.MyApplication;

/**
 * Created by geyifeng on 2017/4/3.
 */

public class GlideUtils {

    public static void load(String s, ImageView imageView){
        Glide.with(MyApplication.getComponent().context())
                .load(s)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.mipmap.glide)
                .listener(new RatioRequestListener(imageView))
                .into(imageView);
    }
    public static void load2(String s, ImageView imageView){
        Glide.with(MyApplication.getComponent().context())
                .load(s)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.mipmap.glide)
                .into(imageView);
    }

    private static class RatioRequestListener implements RequestListener<String,GlideDrawable>{

        ImageView imageView;

        private RatioRequestListener(ImageView imageView){
            this.imageView = imageView;
        }

        @Override
        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
            return false;
        }

        @Override
        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
            if (imageView == null) {
                return false;
            }
            if (imageView.getScaleType() != ImageView.ScaleType.FIT_XY) {
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            ViewGroup.LayoutParams params = imageView.getLayoutParams();
            int vw = imageView.getWidth() - imageView.getPaddingLeft() - imageView.getPaddingRight();
            float scale = (float) vw / (float) resource.getIntrinsicWidth();
            int vh = Math.round(resource.getIntrinsicHeight() * scale);
            params.height = vh + imageView.getPaddingTop() + imageView.getPaddingBottom();
            imageView.setLayoutParams(params);
            return false;
        }
    }
}
