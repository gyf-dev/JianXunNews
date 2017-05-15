package com.gyf.jianxunnews.http;

import com.gyf.jianxunnews.app.MyApplication;
import com.gyf.jianxunnews.mvp.model.bean.AliBean;
import com.gyf.jianxunnews.mvp.model.bean.JokeBean;
import com.gyf.jianxunnews.mvp.model.bean.NewsStatusBean;
import com.gyf.jianxunnews.mvp.model.bean.TodayBean;
import com.gyf.jianxunnews.utils.FileUtils;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
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
    private ApiService mApiService;
    private Retrofit.Builder mBuilder;

    private RetrofitHttp() {
        mBuilder = new Retrofit.Builder()
                .client(client())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
//        Retrofit mRetrofit = new Retrofit.Builder()
//                .client(client())
//                .baseUrl(url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build();
    }

    public static RetrofitHttp getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitHttp.class) {
                mInstance = new RetrofitHttp();
            }
        }
        return mInstance;
    }

    public RetrofitHttp baseUrl(String url) {
        Retrofit mRetrofit = mBuilder.baseUrl(url).build();
        mApiService = mRetrofit.create(ApiService.class);
        return mInstance;
    }

    private OkHttpClient client() {
        return new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .cache(new Cache(FileUtils.getDiskCacheDir(MyApplication.getComponent().context()),
                        1024 * 1024 * 10))
                .addInterceptor(new CacheInterceptor2())
                .addNetworkInterceptor(new CacheInterceptor2())
                .addInterceptor(new AliInterceptor())
                .build();
    }

    /**
     * 笑话接口
     *
     * @param jokeType the joke type
     * @param map      the map
     * @param observer the observer
     */
    public void loadJoke(String jokeType, Map<String, String> map, Observer<JokeBean> observer) {
        mApiService.getJoke(jokeType, map)
                .map(new Function<AliBean<JokeBean>, JokeBean>() {
                    @Override
                    public JokeBean apply(@NonNull AliBean<JokeBean> jokeBeanAliBean) throws Exception {
                        return jokeBeanAliBean.showapi_res_body;
                    }
                })
                .compose(this.<JokeBean>schedulersTransformer())
                .subscribe(observer);
    }

    /**
     * 历史上的今天接口
     *
     * @param data     the data
     * @param observer the observer
     */
    public void loadToday(String data, Observer<TodayBean> observer) {
        mApiService.getToday(data)
                .map(new Function<AliBean<TodayBean>, TodayBean>() {
                    @Override
                    public TodayBean apply(@NonNull AliBean<TodayBean> todayBeanAliBean) throws Exception {
                        return todayBeanAliBean.showapi_res_body;
                    }
                })
                .compose(this.<TodayBean>schedulersTransformer())
                .subscribe(observer);
    }

    /**
     * 新闻接口
     *
     * @param map      the map
     * @param observer the observer
     */
    public void loadNews(Map<String, String> map, Observer<NewsStatusBean> observer) {
        mApiService.getNews(map)
                .compose(this.<NewsStatusBean>schedulersTransformer())
                .subscribe(observer);
    }

    private <T> ObservableTransformer<T, T> schedulersTransformer() {

        return new ObservableTransformer<T, T>() {

            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

}
