package com.hgf.jetpack.ui.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * @author :huangguofeng
 * date    :2020/7/3
 * package :com.hgf.jetpack.ui.base
 * desc    :基础activity
 */
public class BaseActivity extends AppCompatActivity {
    public FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getSupportFragmentManager();
        initView();
        initData();
    }

    /**
     * 每一次执行事务操作都需要重新获取FragmentTransaction，因为每次获取的FragmentTransaction只能进行一次commit操作，
     * 多次commit会报ANR:commit already called，所以只获取一次对象是不可取的
     */
    public FragmentTransaction getFragmentTransaction() {
        return fragmentManager.beginTransaction();
    }

    public void initData() {
    }


    public void initView() {
    }
}
