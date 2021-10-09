package com.lib.base.server;

/**
 * @author :huangguofeng
 * date    :2021/3/4
 * package :com.lib.base.server
 * desc    :适用于model加载数据
 */
public interface IBaseModelListener<T> {

    /**
     * 数据加载成功
     *
     * @param code 加载结果
     * @param data 返回的数据
     */
    void loadSuccess(int code, T data);

    /**
     * 数据加载失败
     *
     * @param code  加载结果
     * @param error 错误信息
     */
    void loadFail(int code, String error);
}
