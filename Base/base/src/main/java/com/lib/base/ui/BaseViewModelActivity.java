package com.lib.base.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;
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
public abstract class BaseViewModelActivity<VIEW_MODEL extends BaseViewModel> extends BasicActivity {
    VIEW_MODEL viewModel;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = initViewModel();
    }

    /**
     * 定义BaseViewModel初始化的参数，配合getViewModelWithSavedStateBundle使用
     *
     * @return : BaseViewModel初始化的参数，默认new Bundle
     */
    protected Bundle setViewModelBundle() {
        return new Bundle();
    }

    /**
     * 实例化泛型VIEW_MODEL
     *
     * @return : VIEW_MODEL
     */
    protected abstract VIEW_MODEL initViewModel();

    /**
     * 最基本ViewModel实例化方式
     */
    protected <VIEW_MODEL extends BaseViewModel> VIEW_MODEL createViewModel(Class<? extends BaseViewModel> model) {
        return (VIEW_MODEL) new ViewModelProvider(this).get(model);
    }

    /**
     * 带有数据保存能力的ViewModel实例化方式
     */
    protected <VIEW_MODEL extends BaseViewModel> VIEW_MODEL createViewModelWithSavedState(Class<? extends BaseViewModel> model) {
        return (VIEW_MODEL) new ViewModelProvider(this, new SavedStateViewModelFactory(getApplication(), this)).get(model);
    }

    /**
     * 带有数据保存能力的ViewModel实例化方式，并且通过重写getBundle方法设置初始化参数传递给对应需要实例化的类model，由其SavedStateHandle携带参数bundle
     */
    protected VIEW_MODEL createViewModelWithSavedStateBundle(Class<? extends BaseViewModel> model) {
        return (VIEW_MODEL) new ViewModelProvider(this, new SavedStateViewModelFactory(getApplication(), this, setViewModelBundle())).get(model);
    }

    protected VIEW_MODEL getViewModel() {
        return viewModel;
    }
}
