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
public abstract class HttpRetrofitCallback<T> implements Callback<T> {
    private static final int SUCCESS_STATE = 200;
    private static final String TAG = "[HttpRetrofitCallback]: ";

    @Override
    public void onResponse(Call call, Response response) {
        logResponse(response);
        if (SUCCESS_STATE == response.code() || response.isSuccessful()) {
            Logger.logDebug(TAG + "网络请求成功: code  = " + HttpResultCode.Success.getCode() + ", msg = " + response.message());
            success(HttpResultCode.Success.getCode(), call, response);
        } else {
            onFail(call, response);
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        Logger.logError(TAG + "网络请求失败: code  = " + HttpResultCode.Fail.getCode() + ", msg = " + t.getMessage());
        fail(HttpResultCode.Fail.getCode(), call, t.getMessage());
    }

    /**
     * 自定义callback
     *
     * @param code     结果码
     * @param call     call对象
     * @param response response返回值
     */
    public abstract void success(int code, Call<T> call, Response<T> response);

    /**
     * 自定义callback
     *
     * @param code  结果码
     * @param call  call对象
     * @param error 错误信息
     */
    public abstract void fail(int code, Call<T> call, String error);

    protected void onFail(Call<T> call, Response<T> response) {
        String errorMsg = null;
        try {
            errorMsg = response.errorBody().string();
            Logger.logError(TAG + "错误信息：" + errorMsg);
        } catch (IOException e) {
            Logger.logError(TAG + "错误信息解析异常:" + e.getMessage());
        }
        if (errorMsg == null) {
            errorMsg = response.message();
        }
        // 根据 errorCode 前端做相应的处理
        Logger.logError(TAG + "网络请求失败: code  = " + response.code() + ", msg = " + errorMsg);
        fail(response.code(), call, errorMsg);
    }

    protected void logResponse(Response response) {
        try {
            if (response != null) {
                HttpRetrofitResponse result = new HttpRetrofitResponse();
                result.setCode(response.code());
                result.setMessage(response.message());
                result.setSuccessful(response.isSuccessful());

                HashMap<String, Object> map = new HashMap<>();
                for (String key : response.headers().names()) {
                    map.put(key, response.headers().get(key));
                }
                if (!map.isEmpty()) {
                    result.setHeads(map);
                }

                if (response.body() != null) {
                    result.setData(response.body().toString());
                }

                if (response.errorBody() != null) {
                    result.setErrorBody(response.errorBody().toString());
                    result.setErrorBodyType(response.errorBody().contentType().toString());
                }
                result.setResponseBody(response.raw().toString());

                Logger.logError(TAG + "logResponse :" + result.toString());
            }

        } catch (Exception e) {
            Logger.logError(TAG + "logResponse 异常:" + e.getMessage());
        }
    }
}
