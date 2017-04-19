package com.gyf.jianxunnews.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gyf.jianxunnews.R;
import com.gyf.jianxunnews.ui.LoadView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by geyifeng on 2017/3/29.
 */

public class HandpickFragment extends Fragment {
    @BindView(R.id.load_view)
    LoadView loadView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_handpick, null, true);
        ButterKnife.bind(this, rootView);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadView.setCurrentStatus(LoadView.LOAD_FAIL);
            }
        },3000);
        loadView.setOnLoadCliCkListener(new LoadView.OnLoadClickListener() {
            @Override
            public void onFailClick() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadView.setCurrentStatus(LoadView.LOAD_FAIL);
                    }
                },3000);
            }

        });

        return rootView;
    }
}
