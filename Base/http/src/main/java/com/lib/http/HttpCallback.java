package com.lib.http;

/**
 * @author :huangguofeng
 * date    :2021/2/3
 * package :com.lib.net
 * desc    :请求回调
 */
public interface HttpCallback<DATA> {

    /**
     * 成功
     *
     * @param code 结果码
     * @param data 数据实体类
     */
    void success(int code, DATA data);

    /**
     * 失败
     *
     * @param errorCode 错误码
     * @param errorMsg  错误信息
     */
    void fail(int errorCode, String errorMsg);
}
