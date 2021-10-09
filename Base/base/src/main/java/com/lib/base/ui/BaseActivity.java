package com.lib.base.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import com.lib.base.viewmodel.BaseViewModel;

/**
 * @author :huangguofeng
 * date    :2021/3/6
 * package :com.lib.base.ui
 * desc    :
 */
public abstract class BaseActivity<DATA_BIND extends ViewDataBinding, VIEW_MODEL extends BaseViewModel> extends BaseViewModelActivity<VIEW_MODEL> {
    DATA_BIND dataBinding;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, getLayoutId());
    }

    /**
     * 获取activity的布局文件
     *
     * @return 布局文件id: R.layout.xxx
     */
    protected abstract int getLayoutId();

    protected DATA_BIND getViewBind() {
        return dataBinding;
    }
}
