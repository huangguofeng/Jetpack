package com.lib.base.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.lib.base.app.BaseApplication;
import com.rxjava.rxlife.ScopeViewModel;

/**
 * @author :huangguofeng
 * date    :2021/3/4
 * package :com.lib.base.viewmodel
 * desc    :ViewModel基类 继承ViewModel
 */
public abstract class BaseViewModel extends ScopeViewModel {

    public BaseViewModel() {
        super(BaseApplication.getApplication());
    }

    public BaseViewModel(SavedStateHandle savedStateHandle) {
        super(BaseApplication.getApplication());
    }
}
