package com.lib.base.server;

import com.lib.base.viewmodel.BaseViewModel;

/**
 * @author :huangguofeng
 * date    :2021/3/4
 * package :com.lib.base.server
 * desc    :自定义view的数据接口
 */
public interface ICustomView<VIEW_MODEL extends BaseViewModel> {
    /**
     * 设置ViewModel
     *
     * @param viewModelData BaseViewModel的继承类
     */
    void setViewModelData(VIEW_MODEL viewModelData);
}
