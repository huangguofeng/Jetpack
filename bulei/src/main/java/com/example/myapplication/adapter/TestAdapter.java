package com.example.myapplication.adapter;

import android.content.Context;

import com.example.myapplication.view.TitleView;
import com.lib.base.adapter.BaseRecycleAdapter;
import com.lib.base.server.ICustomView;
import com.lib.base.viewmodel.BaseViewModel;

/**
 * @author :huangguofeng
 * date    :2021/2/28
 * package :com.example.myapplication.adapter
 * desc    :
 */
public class TestAdapter extends BaseRecycleAdapter<BaseViewModel> {

    public TestAdapter() {

    }

    @Override
    protected ICustomView getCustomView(Context context) {
        return new TitleView(context);
    }

}
