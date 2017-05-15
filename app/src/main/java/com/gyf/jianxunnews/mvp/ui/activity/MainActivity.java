package com.gyf.jianxunnews.mvp.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;
import com.gyf.jianxunnews.R;
import com.gyf.jianxunnews.mvp.ui.fragment.HandpickFragment;
import com.gyf.jianxunnews.mvp.ui.fragment.JokeFragment;
import com.gyf.jianxunnews.mvp.ui.fragment.NewsFragment;
import com.gyf.jianxunnews.view.CustomViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    //    @Inject
//    NewsFragment newsFragment;
//    @Inject
//    JokeFragment jokeFragment;
//    @Inject
//    HandpickFragment handpickFragment;
    @BindView(R.id.tab_news)
    LinearLayout mTab_news;
    @BindView(R.id.tab_joke)
    LinearLayout mTab_joke;
    @BindView(R.id.tab_handpick)
    LinearLayout mTab_handpick;
    @BindView(R.id.main_vp)
    CustomViewPager mMain_vp;
    @BindView(R.id.drawerLayout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.navigation_view)
    ScrollView navigation_view;

    private List<Fragment> fragments = new ArrayList<>();
    private final static int TAB_NEWS = 0;
    private final static int TAB_JOKE = 1;
    private final static int TAB_HANDPICK = 2;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mTab_news.setSelected(true);
        //DaggerMainComponent.create().inject(this);
        NewsFragment newsFragment = new NewsFragment();
        JokeFragment jokeFragment = new JokeFragment();
        HandpickFragment handpickFragment = new HandpickFragment();
        fragments.add(newsFragment);
        fragments.add(jokeFragment);
        fragments.add(handpickFragment);
        mMain_vp.setAdapter(new MyAdapter(getSupportFragmentManager()));
        mMain_vp.setCurrentItem(TAB_NEWS);
        mMain_vp.setOffscreenPageLimit(2);
        mMain_vp.setScroll(false); //设置不可滑动
        mMain_vp.addOnPageChangeListener(new MyListener());
    }

//    }

    @OnClick({R.id.tab_news, R.id.tab_joke, R.id.tab_handpick})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tab_news:
                mMain_vp.setCurrentItem(TAB_NEWS);
                break;
            case R.id.tab_joke:
                mMain_vp.setCurrentItem(TAB_JOKE);
                break;
            case R.id.tab_handpick:
                mMain_vp.setCurrentItem(TAB_HANDPICK);
                break;
        }

    }

    private class MyAdapter extends FragmentPagerAdapter {
        private MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

    private class MyListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            changeView(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    }

    private void changeView(int position) {
        switch (position) {
            case TAB_NEWS:
                changeIcon(mTab_news);
                break;
            case TAB_JOKE:
                changeIcon(mTab_joke);
                break;
            case TAB_HANDPICK:
                changeIcon(mTab_handpick);
                break;
        }
    }

    private void changeIcon(LinearLayout linearLayout) {
        mTab_news.setSelected(false);
        mTab_joke.setSelected(false);
        mTab_handpick.setSelected(false);
        linearLayout.setSelected(true);
    }

    @Override
    public boolean isSupportSwipeBack() {
        return false;
    }

    private long exitTime = 0;

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出简讯新闻", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
