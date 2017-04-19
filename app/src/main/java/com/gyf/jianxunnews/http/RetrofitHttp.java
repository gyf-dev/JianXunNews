package com.gyf.jianxunnews.http;

import com.gyf.jianxunnews.app.MyApplication;
import com.gyf.jianxunnews.model.bean.IJokeBean;
import com.gyf.jianxunnews.model.bean.TodayBean;
import com.gyf.jianxunnews.utils.FileUtils;
import com.gyf.jianxunnews.utils.UrlUtil;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by geyifeng on 2017/4/1.
 */

public class RetrofitHttp {

    private static RetrofitHttp mInstance;
    private ApiService mJokeService;

    private RetrofitHttp() {
        Retrofit mRetrofit = new Retrofit.Builder()
                .client(client())
                .baseUrl(UrlUtil.JOKE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mJokeService = mRetrofit.create(ApiService.class);
    }

    public static RetrofitHttp getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitHttp.class) {
                mInstance = new RetrofitHttp();
            }
        }
        return mInstance;
    }

    private OkHttpClient client() {
        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .cache(new Cache(FileUtils.getDiskCacheDir(MyApplication.getComponent().context()),
                        1024 * 1024 * 10))
                .addInterceptor(new CacheInterceptor2())
                .addNetworkInterceptor(new CacheInterceptor2())
                .addInterceptor(new JokeInterceptor())
                .build();
    }

    public void loadTextJoke(Map<String, String> map, Observer<IJokeBean> observer) {
        mJokeService.getTextJoke(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void loadPicJoke(Map<String, String> map, Observer<IJokeBean> observer) {
        mJokeService.getPicJoke(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void loadGifJoke(Map<String, String> map, Observer<IJokeBean> observer) {
        mJokeService.getGifJoke(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void loadToday(String data, Observer<TodayBean> observer) {
        mJokeService.getToday(data)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

}
