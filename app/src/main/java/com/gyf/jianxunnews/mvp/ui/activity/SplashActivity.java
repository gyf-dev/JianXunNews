package com.gyf.jianxunnews.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.gyf.barlibrary.ImmersionBar;
import com.gyf.jianxunnews.R;
import com.gyf.jianxunnews.view.CircleTextProgressbar;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by geyifeng on 2017/5/5.
 */

public class SplashActivity extends BaseActivity {

    @BindView(R.id.iv_splash)
    ImageView mImageView;
    @BindView(R.id.progress)
    CircleTextProgressbar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //BarManager.setBarColor(this,true);
        ImmersionBar.with(this).transparentBar().init();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        progressBar.setProgressType(CircleTextProgressbar.ProgressType.COUNT);
        progressBar.setProgressLineWidth(5);
        progressBar.setTimeMillis(3000);
        progressBar.setProgressColor(ContextCompat.getColor(SplashActivity.this, R.color.colorPrimary));
        progressBar.setOutLineColor(ContextCompat.getColor(SplashActivity.this, R.color.timer_background));
        progressBar.start();
    }

    @Override
    protected void setListener() {
        progressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity();
            }
        });
    }

    @Override
    protected void initData() {
        Glide.with(this).load(R.mipmap.splash).centerCrop().into(mImageView);
        Observable.timer(3, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        toActivity();
                    }
                });
    }

    private void toActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean isSupportSwipeBack() {
        return false;
    }
}
