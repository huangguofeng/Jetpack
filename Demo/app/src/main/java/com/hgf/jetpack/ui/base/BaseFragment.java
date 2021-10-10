package com.hgf.jetpack.ui.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hgf.jetpack.utils.ILog;

/**
 * @author :huangguofeng
 * date    :2020/7/3
 * package :com.hgf.jetpack.ui.base
 * desc    :基础fragment
 */
public class BaseFragment extends Fragment {
    private String TAG;

    public BaseFragment() {
        ILog.logInfo("BaseFragment : 实例化");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public String getTAG() {
        return TAG;
    }

    public void setTAG(String TAG) {
        this.TAG = TAG;
    }
}
