package com.gyf.jianxunnews.http;

import com.gyf.jianxunnews.mvp.model.bean.JokeBean;
import com.gyf.jianxunnews.mvp.model.bean.NewsBean;
import com.gyf.jianxunnews.mvp.model.bean.NewsStatusBean;
import com.gyf.jianxunnews.mvp.model.bean.TodayBean;
import com.gyf.jianxunnews.mvp.model.bean.AliBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by geyifeng on 2017/3/30.
 */

public interface ApiService {
    @GET("{joke}")
    Observable<AliBean<JokeBean>> getJoke(@Path("joke") String joke, @QueryMap Map<String, String> map);

    @GET("today-of-history")
    Observable<AliBean<TodayBean>> getToday(@Query("date") String date);

    @GET("news/get")
    Observable<NewsStatusBean> getNews(@QueryMap Map<String, String> map);
}
