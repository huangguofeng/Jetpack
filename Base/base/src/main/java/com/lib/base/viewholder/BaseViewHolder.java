package com.lib.base.viewholder;

import androidx.annotation.NonNull;

import com.lib.base.server.ICustomView;
import com.lib.base.viewmodel.BaseViewModel;

/**
 * @author :huangguofeng
 * date    :2021/3/4
 * package :com.lib.base.viewholder
 * desc    :基类ViewHolder List专用
 */
public class BaseViewHolder {
    ICustomView iCustomView;

    public BaseViewHolder(@NonNull ICustomView itemView) {
        iCustomView = itemView;
    }

    public void bind(BaseViewModel model) {
        iCustomView.setViewModelData(model);
    }
}
