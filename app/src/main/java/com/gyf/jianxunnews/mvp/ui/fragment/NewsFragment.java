package com.gyf.jianxunnews.mvp.ui.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import com.flyco.tablayout.SlidingTabLayout;
import com.gyf.barlibrary.ImmersionBar;
import com.gyf.jianxunnews.R;
import com.gyf.jianxunnews.mvp.ui.activity.TodayActivity;
import com.gyf.jianxunnews.view.CustomViewPager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by geyifeng on 2017/3/29.
 */

public class NewsFragment extends BaseFragment {

    @BindView(R.id.iv_tab_my)
    ImageView iv_tab_my;
    @BindView(R.id.iv_tab_today)
    ImageView iv_tab_today;
    @BindView(R.id.vp_news_common)
    CustomViewPager mVp;
    @BindView(R.id.sliding)
    SlidingTabLayout mSliding;
    @BindView(R.id.iv_find_news)
    ImageView iv_find_news;

    private final String[] mChannel = {
            "头条", "新闻", "财经", "体育", "娱乐", "军事", "教育", "科技", "NBA", "股票", "星座", "女性", "健康", "育儿"
    };

    ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected int setLayoutId() {
        //ImmersionBar.with(mActivity).statusBarDarkFont(true).init();
        return R.layout.fragment_news;
    }

    @Override
    protected boolean isLazyLoad() {
        return true;
    }

    @Override
    protected void initView() {
        for (String channel : mChannel) {
            fragments.add(NewsCommonFragment.newInstance(channel));
        }
        mVp.setAdapter(new MyAdapter(getChildFragmentManager()));
        mVp.setOffscreenPageLimit(4);
        mSliding.setViewPager(mVp);
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.iv_tab_my, R.id.iv_tab_today})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_tab_my:
                DrawerLayout drawerLayout = findActivityViewById(R.id.drawerLayout);
                drawerLayout.openDrawer(Gravity.LEFT);
                break;
            case R.id.iv_tab_today:
                Intent intent = new Intent(mActivity, TodayActivity.class);
                mActivity.startActivity(intent);
                break;
        }
    }


    private class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        public CharSequence getPageTitle(int position) {
            return mChannel[position];
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }
    }
}
