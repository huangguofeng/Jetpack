package com.example.framework.mvp;

/**
 * @author :huangguofeng
 * date    :2021/8/10
 * package :com.example.framework.mvp
 * desc    :Presenter角色
 */
public class Presenter implements IPresenter {
    private IView iView;
    private IModel iModel;

    @Override
    public void setView(IView view) {
        iView = view;
    }

    @Override
    public void setModel(IModel model) {
        iModel = model;
    }

    @Override
    public void updateData(String data) {
        iView.show(data);
    }

    @Override
    public void deleteData() {
        iView.show("空");
    }

    @Override
    public void textChange(String text) {
        iView.load();
        iModel.setData(text);
    }

    @Override
    public void cleanClick() {
        iModel.cleanData();
    }
}
