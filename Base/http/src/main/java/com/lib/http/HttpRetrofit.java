package com.lib.http;

import android.content.Context;

import java.util.HashMap;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author :huangguofeng
 * date    :2021/3/3
 * package :com.lib.net
 * desc    :
 */
public class HttpRetrofit {
    private static final String TAG = "[HttpRetrofit]: ";
    private static HttpRetrofit httpRetrofit;
    private HashMap<String, Retrofit> retrofits = new HashMap<>();
    private Context context;

    private HttpRetrofit(Context c) {
        if (context == null && c != null) {
            context = c;
        }
    }

    public static HttpRetrofit get(Context... contexts) {
        if (httpRetrofit == null) {
            synchronized (HttpRetrofit.class) {
                if (httpRetrofit == null) {
                    httpRetrofit = new HttpRetrofit(contexts[0]);
                }
            }
        }
        return httpRetrofit;
    }

    public synchronized Retrofit getRetrofit(String baseUrl) {
        if (retrofits.size() != 0) {
            if (retrofits.get(baseUrl) != null) {
                return retrofits.get(baseUrl);
            }
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        retrofits.put(baseUrl, retrofit);
        return retrofit;
    }

}
