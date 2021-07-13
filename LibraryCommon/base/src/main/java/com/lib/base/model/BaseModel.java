package com.lib.base.model;


import com.lib.base.server.IBaseModelListener;

/**
 * @author :huangguofeng
 * date    :2021/3/1
 * package :com.lib.base.model
 * desc    :基类模型数据
 */
public abstract class BaseModel {
    protected IBaseModelListener iBaseModelListener;

    public BaseModel(IBaseModelListener listener) {
        this.iBaseModelListener = listener;
    }

    protected IBaseModelListener getIBaseModelListener() {
        return iBaseModelListener;
    }

    /**
     * 数据加载
     */
    public abstract void load();


}
