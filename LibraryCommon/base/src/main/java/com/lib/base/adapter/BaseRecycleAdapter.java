package com.lib.base.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lib.base.server.ICustomView;
import com.lib.base.viewholder.BaseRecycleViewHolder;
import com.lib.base.viewmodel.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :huangguofeng
 * date    :2021/3/6
 * package :com.lib.base.adapter
 * desc    :
 */
public abstract class BaseRecycleAdapter<T extends BaseViewModel> extends RecyclerView.Adapter<BaseRecycleViewHolder> {
    protected List<T> items = new ArrayList<>();

    public void setItems(List<T> mItems) {
        this.items = mItems;
        notifyDataSetChanged();
    }

    @NonNull
    @Override

    public BaseRecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BaseRecycleViewHolder(getCustomView(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRecycleViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    /**
     * 设置view holder的绑定的自定义view
     *
     * @param context context
     * @return ICustomView 实现ICustomView接口的自定义view
     */
    protected abstract ICustomView getCustomView(Context context);
}
