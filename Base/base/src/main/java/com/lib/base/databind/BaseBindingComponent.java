package com.lib.base.databind;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingComponent;

import com.bumptech.glide.Glide;

/**
 * @author :huangguofeng
 * date    :2021/3/4
 * package :com.lib.base.databind
 * desc    :基类绑定适配器 目前有设置文本颜色和图片url
 * TODO: DataBindingComponent是运行时生成的，clean会导致找不到类，重新编译即可
 */
public class BaseBindingComponent implements DataBindingComponent {

    /**
     * imageUrl: 自定义app属性
     *
     * @param imageView 使用自定义app属性名的ImageView
     * @param url       该自定义app属性名在ImageView中的属性值
     */
    @BindingAdapter("imageUrl")
    public void loadImage(ImageView imageView, String url) {
        if (!TextUtils.isEmpty(url)) {
            Glide.with(imageView.getContext()).load(url).into(imageView);
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public BaseBindingComponent getBaseBindingComponent() {
        return this;
    }
}
