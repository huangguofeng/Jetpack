package com.lib.http;

import com.lib.utils.Logger;

import java.io.IOException;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author :huangguofeng
 * date    :2021/3/9
 * package :com.lib.http
 * desc    :
 */
public abstract class RetrofitCallback<T> implements Callback<T> {
    private static final int SUCCESS_STATE = 200;
    private static final String TAG = "[HttpRetrofitCallback]: ";

    @Override
    public void onResponse(Call call, Response response) {
        if(response.isSuccessful()){
            success(response);
        }else {
            fail(new Throwable("response isSuccessful : false"));
        }

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
       fail(t);
    }

    /**
     * 自定义callback
     *
     * @param response response返回值
     */
    public abstract void success(Response<T> response);

    /**
     * 自定义callback
     *
     * @param throwable 错误信息
     */
    public abstract void fail(Throwable throwable);
}
