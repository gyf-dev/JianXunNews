package com.gyf.jianxunnews.model;


import com.gyf.jianxunnews.model.listener.OnLoadJokeListListener;

import java.util.Map;

/**
 * Created by geyifeng on 2017/3/30.
 */

public interface IJokeModel{
    void loadTextJoke(Map<String, String> map, OnLoadJokeListListener listener);
    void loadPicJoke(Map<String, String> map, OnLoadJokeListListener listener);
    void loadGifJoke(Map<String, String> map, OnLoadJokeListListener listener);
}
