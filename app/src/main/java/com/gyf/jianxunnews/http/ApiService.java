package com.gyf.jianxunnews.http;

import com.gyf.jianxunnews.model.bean.JokeImgBean;
import com.gyf.jianxunnews.model.bean.JokeTextBean;
import com.gyf.jianxunnews.model.bean.TodayBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by geyifeng on 2017/3/30.
 */

public interface ApiService {
    @GET("textJoke")
    Observable<JokeTextBean> getTextJoke(@QueryMap Map<String, String> map);

    @GET("picJoke")
    Observable<JokeImgBean> getPicJoke(@QueryMap Map<String, String> map);

    @GET("gifJoke")
    Observable<JokeImgBean> getGifJoke(@QueryMap Map<String, String> map);

    @GET("today-of-history")
    Observable<TodayBean> getToday(@Query("data") String s);
}
