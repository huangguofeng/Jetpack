package com.lib.base.view;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.lib.base.server.ICustomView;
import com.lib.base.viewmodel.BaseViewModel;

/**
 * @author :huangguofeng
 * date    :2021/3/4
 * package :com.lib.base.view
 * desc    :自定义View基类
 */
public abstract class BaseCustomView<VIEW_MODEL extends BaseViewModel, DATA_BIND extends ViewDataBinding> extends LinearLayout implements ICustomView<VIEW_MODEL> {
    protected VIEW_MODEL view_model;
    protected DATA_BIND data_bind;

    public BaseCustomView(Context context) {
        super(context);
        init();
    }

    public BaseCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BaseCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BaseCustomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (getLayoutId() != 0) {
            data_bind = DataBindingUtil.inflate(inflater, getLayoutId(), this, false);
            data_bind.getRoot().setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    onRootClick(v);
                }
            });
            addView(data_bind.getRoot());
        }
    }

    @Override
    public void setViewModelData(VIEW_MODEL viewModelData) {
        view_model = viewModelData;
        setData(view_model);
        if (data_bind != null) {
            data_bind.executePendingBindings();
        }
    }

    /**
     * 获取自定义view的布局文件
     *
     * @return 布局文件id: R.layout.xxx
     */
    protected abstract int getLayoutId();

    /**
     * 根布局点击事件
     *
     * @param view 根布局view
     */
    protected abstract void onRootClick(View view);

    /**
     * 设置viewModel数据 getDataBind().setXXX
     *
     * @param viewModel viewModel数据
     */
    protected abstract void setData(VIEW_MODEL viewModel);

    /**
     * 获取viewModel
     */
    protected VIEW_MODEL getViewModel() {
        return view_model;
    }

    /**
     * 获取binding
     */
    protected DATA_BIND getDataBind() {
        return data_bind;
    }
}
