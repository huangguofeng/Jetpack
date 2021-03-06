package com.lib.base.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import com.lib.base.viewmodel.BaseViewModel;

/**
 * @author :huangguofeng
 * date    :2021/3/6
 * package :com.lib.base.ui
 * desc    :
 */
public abstract class BaseViewModelFragment<VIEW_MODEL extends BaseViewModel> extends BasicFragment {
    VIEW_MODEL viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = initViewModel();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    /**
     * 定义BaseViewModel初始化的参数，配合getViewModelWithSavedStateBundle使用
     *
     * @return : BaseViewModel初始化的参数
     */
    protected Bundle setViewModelBundle() {
        return new Bundle();
    }

    /**
     * 实例化泛型T
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
        return (VIEW_MODEL) new ViewModelProvider(this, new SavedStateViewModelFactory(requireActivity().getApplication(), this)).get(model);
    }

    /**
     * 带有数据保存能力的ViewModel实例化方式，并且通过重写getBundle方法设置初始化参数传递给对应需要实例化的类model，由其SavedStateHandle携带参数bundle
     */
    protected VIEW_MODEL getViewModelWithSavedStateBundle(Class<? extends BaseViewModel> model) {
        return (VIEW_MODEL) new ViewModelProvider(this, new SavedStateViewModelFactory(requireActivity().getApplication(), this, setViewModelBundle())).get(model);
    }

    protected VIEW_MODEL getViewModel() {
        return viewModel;
    }
}
