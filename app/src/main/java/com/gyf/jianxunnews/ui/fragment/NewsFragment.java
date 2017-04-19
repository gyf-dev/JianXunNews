package com.gyf.jianxunnews.ui.fragment;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.apkfuns.logutils.LogUtils;
import com.gyf.jianxunnews.R;
import com.gyf.jianxunnews.ui.LoadView;
import com.gyf.jianxunnews.ui.activity.TodayActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by geyifeng on 2017/3/29.
 */

public class NewsFragment extends BaseFragment2 {

    @BindView(R.id.load_view)
    LoadView loadView;
    @BindView(R.id.iv_tab_my)
    ImageView iv_tab_my;
    @BindView(R.id.iv_tab_today)
    ImageView iv_tab_today;

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    protected boolean isLazyLoad() {
        return false;
    }

    @Override
    protected void initData() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadView.setCurrentStatus(LoadView.LOAD_FAIL);
            }
        }, 3000);
        loadView.setOnLoadCliCkListener(new LoadView.OnLoadClickListener() {
            @Override
            public void onFailClick() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadView.setCurrentStatus(LoadView.LOAD_FAIL);
                    }
                }, 3000);
            }

        });
    }

    @OnClick({R.id.iv_tab_my, R.id.iv_tab_today})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_tab_my:
                ScrollView scrollView = (ScrollView) getActivity().findViewById(R.id.navigation_view);
                DrawerLayout drawerLayout = findActivityViewById(R.id.drawerLayout);
               // DrawerLayout drawerLayout = (DrawerLayout) findActivityViewById(R.id.drawerLayout);
                drawerLayout.openDrawer(Gravity.LEFT);
                break;
            case R.id.iv_tab_today:
                Intent intent = new Intent(mActivity, TodayActivity.class);
                mActivity.startActivity(intent);
                break;
        }

    }
}
