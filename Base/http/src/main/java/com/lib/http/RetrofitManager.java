package com.lib.http;

import com.lib.utils.Logger;

import java.util.HashMap;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author :huangguofeng
 * date    :2021/3/3
 * package :com.lib.net
 * desc    :
 */
public class RetrofitManager {
    private static final String TAG = "[RetrofitManager]: ";
    private static RetrofitManager retrofitManager;
    private HashMap<String, Retrofit> retrofits = new HashMap<>();

    private RetrofitManager() {

    }

    public static RetrofitManager get() {
        if (retrofitManager == null) {
            synchronized (RetrofitManager.class) {
                if (retrofitManager == null) {
                    retrofitManager = new RetrofitManager();
                }
            }
        }
        return retrofitManager;
    }

    public Retrofit getRetrofit(String baseUrl) {
        if (retrofits.size() != 0) {
            if (retrofits.get(baseUrl) != null) {
                return retrofits.get(baseUrl);
            }
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        retrofits.put(baseUrl, retrofit);
        return retrofit;
    }
}
