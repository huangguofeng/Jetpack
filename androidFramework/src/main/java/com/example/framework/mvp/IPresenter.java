package com.example.framework.mvp;

/**
 * @author :huangguofeng
 * date    :2021/8/10
 * package :com.example.framework.mvp
 * desc    :Presenter角色
 */
public interface IPresenter {
    void setView(IView view);

    void setModel(IModel model);

    void updateData(String data);

    void deleteData();

    void textChange(String text);

    void cleanClick();
}
