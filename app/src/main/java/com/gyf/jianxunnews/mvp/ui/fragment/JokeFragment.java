package com.gyf.jianxunnews.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gyf.jianxunnews.R;
import com.lzy.widget.AlphaIndicator;
import com.lzy.widget.AlphaView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by geyifeng on 2017/3/29.
 */

public class JokeFragment extends Fragment {

    private List<Fragment> fragments = new ArrayList<>();

    @Inject
    JokeTextFragment jokeTextFragment;
    @Inject
    JokePicFragment jokePicFragment;
    @Inject
    JokeGifFragment jokeGifFragment;
    @BindView(R.id.joke_vp)
    ViewPager mJoke_vp;
    @BindView(R.id.alphaIndicator)
    AlphaIndicator mAlpha;
    @BindView(R.id.title_text)
    AlphaView mTitle_text;
    @BindView(R.id.title_img)
    AlphaView mTitle_img;
    @BindView(R.id.title_dynamic)
    AlphaView mTitle_dynamic;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_joke, null);
        ButterKnife.bind(this, rootView);
        initFragment();
        return rootView;
    }

    private void initFragment() {
        // DaggerJokeComponent.builder().jokeModule(new JokeModule()).build().inject(this);
        JokeTextFragment jokeTextFragment = new JokeTextFragment();
        JokePicFragment jokePicFragment = new JokePicFragment();
        JokeGifFragment jokeGifFragment = new JokeGifFragment();
        fragments.add(jokeTextFragment);
        fragments.add(jokePicFragment);
        fragments.add(jokeGifFragment);
        mJoke_vp.setAdapter(new MyAdapter(getChildFragmentManager()));
        mJoke_vp.setOffscreenPageLimit(2);
        mAlpha.setViewPager(mJoke_vp);
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
}
