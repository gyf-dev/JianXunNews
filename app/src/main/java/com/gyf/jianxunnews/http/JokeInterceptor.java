package com.gyf.jianxunnews.http;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by geyifeng on 2017/4/2.
 */

public class JokeInterceptor implements Interceptor {

    private static final String appCode = "APPCODE e1ce59660124429badd52b0143fcec41";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder()
                .addHeader("Authorization", appCode)
                .build();
        return chain.proceed(request);
    }
}
