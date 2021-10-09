package com.example.myapplication.utils;

import com.lib.http.RetrofitResponse;
import com.lib.utils.Logger;

import java.util.HashMap;

import retrofit2.Response;

public class RetrofitUtils {
    private static final String TAG = "[RetrofitUtils]: ";
    public static void logResponse(Response response) {
        try {
            if (response != null) {
                RetrofitResponse result = new RetrofitResponse();
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

                Logger.logDebug(TAG + "logResponse :" + result.toString());
                Logger.logDebug(TAG + "logResponse data :" + result.getData());
            }

        } catch (Exception e) {
            Logger.logError(TAG + "logResponse 异常:" + e.getMessage());
        }
    }
}
