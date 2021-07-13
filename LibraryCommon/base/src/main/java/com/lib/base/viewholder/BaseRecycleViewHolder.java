package com.lib.base.viewholder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lib.base.server.ICustomView;
import com.lib.base.viewmodel.BaseViewModel;

/**
 * @author :huangguofeng
 * date    :2021/3/4
 * package :com.lib.base.viewholder
 * desc    :基类ViewHolder RecycleView专用
 */
public class BaseRecycleViewHolder extends RecyclerView.ViewHolder {
    ICustomView iCustomView;

    public BaseRecycleViewHolder(@NonNull ICustomView view) {
        super((View) view);
        iCustomView = view;
    }

    public void bind(BaseViewModel viewModel) {
        iCustomView.setViewModelData(viewModel);
    }
}
