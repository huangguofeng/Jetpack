package com.lib.http;

/**
 * @author :huangguofeng
 * date    :2021/2/3
 * package :com.lib.net
 * desc    :结果返回
 */
public enum HttpResultCode {
    
    /**
     * 成功
     */
    Success(0),

    /**
     * 失败
     */
    Fail(1);

    /**
     * 结果对应的code
     */
    private final int code;

    HttpResultCode(int code) {
        this.code = code;
    }


    public int getCode() {
        return code;
    }
}
