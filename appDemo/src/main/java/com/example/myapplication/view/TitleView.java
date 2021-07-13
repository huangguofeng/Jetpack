package com.example.myapplication.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import com.example.myapplication.Constant;
import com.example.myapplication.R;
import com.example.myapplication.databinding.TitleViewBinding;
import com.example.myapplication.vm.TitleViewViewModel;
import com.lib.base.view.BaseCustomView;
import com.lib.utils.Logger;

/**
 * @author :huangguofeng
 * date    :2021/2/28
 * package :com.example.myapplication.view
 * desc    :
 */
public class TitleView extends BaseCustomView<TitleViewViewModel, TitleViewBinding> {


    public TitleView(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutId() {
        Logger.logDebug(Constant.TAG, "getLayoutId " + R.layout.title_view);
        return R.layout.title_view;
    }

    @Override
    protected void onRootClick(View view) {
        if (!TextUtils.isEmpty(getViewModel().dataBean.url)) {
            // 跳转web activity
            Logger.logDebug(Constant.TAG, "onRootClick ");
        } else {

        }
    }

    @Override
    protected void setData(TitleViewViewModel viewModel) {
        getDataBind().setNews(viewModel.dataBean);
    }
}
