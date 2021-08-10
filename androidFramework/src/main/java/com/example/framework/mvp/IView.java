package com.example.framework.mvp;

/**
 * @author :huangguofeng
 * date    :2021/8/10
 * package :com.example.framework.mvp
 * desc    :View的接口
 */
public interface IView {
    void setPresenter(IPresenter presenter);

    void load();

    void show(String data);
}
