package com.example.framework.mvp;

/**
 * @author :huangguofeng
 * date    :2021/8/10
 * package :com.example.framework.mvp
 * desc    :Model的接口
 */
public interface IModel {
    void setPresenter(IPresenter presenter);

    void setData(String data);

    void cleanData();
}
