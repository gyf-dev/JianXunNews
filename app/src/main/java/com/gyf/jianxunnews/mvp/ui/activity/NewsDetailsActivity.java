package com.gyf.jianxunnews.mvp.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.apkfuns.logutils.LogUtils;
import com.gyf.jianxunnews.R;
import com.gyf.jianxunnews.mvp.model.bean.NewsBean;
import com.gyf.jianxunnews.view.LoadView;
import com.gyf.jianxunnews.view.TitleView;
import com.lzy.widget.vertical.VerticalWebView;

import butterknife.BindView;
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

/**
 * Created by geyifeng on 2017/5/4.
 */

public class NewsDetailsActivity extends BaseActivity {

    @BindView(R.id.title_view)
    TitleView mTitleView;
    @BindView(R.id.wv_news)
    VerticalWebView mWebView;
    @BindView(R.id.load_view)
    LoadView mLoadView;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_news_details;
    }

    @Override
    protected void initView() {
        WebSettings settings = mWebView.getSettings();
        //对离线应用的支持
        settings.setDomStorageEnabled(true);
        String appCacheDir = this.getApplicationContext().getDir("cache", Context.MODE_PRIVATE).getPath();
        settings.setAppCachePath(appCacheDir);
        settings.setAllowFileAccess(true);
        settings.setAppCacheEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        mWebView.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);
        mLoadView.setCurrentStatus(LoadView.LOAD_LOADING);
        mWebView.setVisibility(View.GONE);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        NewsBean item = (NewsBean) bundle.getSerializable("news_details");
        if (item != null){
            mWebView.loadDataWithBaseURL(null, getHtmlData(item.getContent()), "text/html", "utf-8", null);
            mLoadView.setCurrentStatus(LoadView.LOAD_SUCCESS);
            mWebView.setVisibility(View.VISIBLE);
        }else {
            mLoadView.setCurrentStatus(LoadView.LOAD_FAIL);
            mWebView.setVisibility(View.GONE);
        }

    }

    private String getHtmlData(String bodyHTML) {
        String head = "<head><style>img{max-width: 100%; width:auto; height: auto;}</style></head>";
        return "<html>" + head + "<body>" + bodyHTML + "</body></html>";
    }

    @Override
    protected void setListener() {
        mTitleView.setOnItemClickListener(new TitleView.OnItemClickListener() {
            @Override
            public void onLeftClick() {
                finish();
            }

            @Override
            public void onRightClick() {

            }

            @Override
            public void onMiddleClick() {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
