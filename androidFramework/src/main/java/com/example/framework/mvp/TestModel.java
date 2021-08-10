package com.example.framework.mvp;

/**
 * @author :huangguofeng
 * date    :2021/8/10
 * package :com.example.framework.mvp
 * desc    :Model角色：数据类
 */
public class TestModel implements IModel {
    private IPresenter presenter;
    private String data;

    public TestModel() {

    }

    @Override
    public void setPresenter(IPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setData(String data) {
        this.data = data;
        presenter.updateData(data);
    }

    @Override
    public void cleanData() {
        presenter.deleteData();
    }
}
