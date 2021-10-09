package com.lib.base.model;


import com.lib.base.app.BaseApplication;
import com.lib.base.server.IBaseModelListener;
import com.rxjava.rxlife.ScopeViewModel;

/**
 * @author :huangguofeng
 * date    :2021/3/1
 * package :com.lib.base.model
 * desc    :基类模型数据
 */
public abstract class BaseModel extends ScopeViewModel {
    protected IBaseModelListener iBaseModelListener;

    public BaseModel(IBaseModelListener listener) {
        super(BaseApplication.getApplication());
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
