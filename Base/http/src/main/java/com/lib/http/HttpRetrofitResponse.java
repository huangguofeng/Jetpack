package com.lib.http;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * @author :huangguofeng
 * date    :2021/2/4
 * package :com.lib.net
 * desc    :
 */
public class HttpRetrofitResponse {
    private String message;
    private int code;
    private HashMap<String, Object> heads;
    private String data;
    private boolean isSuccessful;

    private String errorBody;
    private String errorBodyType;
    private String responseBody;

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public String getErrorBodyType() {
        return errorBodyType;
    }

    public void setErrorBodyType(String errorBodyType) {
        this.errorBodyType = errorBodyType;
    }

    public String getErrorBody() {
        return errorBody;
    }

    public void setErrorBody(String errorBody) {
        this.errorBody = errorBody;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public HashMap<String, Object> getHeads() {
        return heads;
    }

    public void setHeads(HashMap<String, Object> heads) {
        this.heads = heads;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    private String printHeads(HashMap<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        JSONObject jsonObject = new JSONObject(map);
        return jsonObject.toString();
    }

    @Override
    public String toString() {
        return "HttpRetrofitResponse{" +
                "message='" + message + '\'' +
                ", code=" + code +
                ", heads=" + printHeads(heads) +
                ", data='" + data + '\'' +
                ", isSuccessful=" + isSuccessful +
                ", errorBody='" + errorBody + '\'' +
                ", errorBodyType='" + errorBodyType + '\'' +
                ", responseBody='" + responseBody + '\'' +
                '}';
    }
}
