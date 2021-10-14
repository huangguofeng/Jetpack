package com.lib.base.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * @author :huangguofeng
 * date    :2021/3/6
 * package :com.lib.base.ui
 * desc    :
 */
public abstract class BasicFragment extends Fragment {
    Bundle defaultBundle = null;
    protected final static String BUNDLE_DEFAULT_FRAGMENT = "isDefault_fragment";
    FragmentManager fm;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fm = getChildFragmentManager();
        if (getArguments() != null) {
            defaultBundle = getArguments();
        } else {
            defaultBundle = new Bundle();
            defaultBundle.putBoolean(BUNDLE_DEFAULT_FRAGMENT, true);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    /**
     * 获取activity的布局文件
     *
     * @return 布局文件id: R.layout.xxx
     */
    protected abstract int getLayoutId();

    /**
     * 无需判空的从bundle中取数据，用于获取intent传递的数据
     *
     * @return : 非空的Bundle
     */
    protected Bundle getBundle() {
        return defaultBundle;
    }

    protected FragmentManager getChildFm() {
        return fm;
    }

    protected FragmentTransaction getChildFt() {
        return fm.beginTransaction();
    }
}
