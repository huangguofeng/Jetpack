package com.lib.base.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import com.lib.base.viewmodel.BaseViewModel;

/**
 * @author :huangguofeng
 * date    :2021/3/6
 * package :com.lib.base.ui
 * desc    :
 */
public abstract class BaseActivity<VIEW_BIND extends ViewDataBinding, VIEW_MODEL extends BaseViewModel> extends AppCompatActivity {
    VIEW_BIND viewBind;
    VIEW_MODEL viewModel;
    FragmentManager fragmentManager;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBind = DataBindingUtil.setContentView(this, getLayoutId());
        viewModel = initViewModel();
        fragmentManager = getSupportFragmentManager();
    }

    /**
     * 获取activity的布局文件
     *
     * @return 布局文件id: R.layout.xxx
     */
    protected abstract int getLayoutId();

    /**
     * 定义BaseViewModel初始化的参数，配合getViewModelWithSavedStateBundle使用
     *
     * @return : BaseViewModel初始化的参数
     */
    protected Bundle getBundle() {
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
    protected <VIEW_MODEL extends BaseViewModel> VIEW_MODEL getViewModel(Class<? extends BaseViewModel> model) {
        return (VIEW_MODEL) new ViewModelProvider(this).get(model);
    }

    /**
     * 带有数据保存能力的ViewModel实例化方式
     */
    protected <VIEW_MODEL extends BaseViewModel> VIEW_MODEL getViewModelWithSavedState(Class<? extends BaseViewModel> model) {
        return (VIEW_MODEL) new ViewModelProvider(this, new SavedStateViewModelFactory(getApplication(), this)).get(model);
    }

    /**
     * 带有数据保存能力的ViewModel实例化方式，并且通过重写getBundle方法设置初始化参数传递给对应需要实例化的类model，由其SavedStateHandle携带参数bundle
     */
    protected VIEW_MODEL getViewModelWithSavedStateBundle(Class<? extends BaseViewModel> model) {
        return (VIEW_MODEL) new ViewModelProvider(this, new SavedStateViewModelFactory(getApplication(), this, getBundle())).get(model);
    }

    protected VIEW_MODEL getViewModel() {
        return viewModel;
    }

    protected VIEW_BIND getViewBind() {
        return viewBind;
    }
}
