package com.example.androidbase.recycle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.androidbase.R;
import com.lib.utils.Logger;

/**
 * @author :huangguofeng
 * date    :2021/7/29
 * package :com.example.androidbase.recycle
 * desc    :
 */
public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.MyViewHolder> {
    private Context context;

    public MyRecycleAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Logger.logInfo((position % 3) + "");
        if (position % 5 == 0) {
            Glide.with(context).load(R.mipmap.image0).into(holder.imageView);
        }
        if (position % 5 == 1) {
            Glide.with(context).load(R.mipmap.image1).into(holder.imageView);
        }
        if (position % 5 == 2) {
            Glide.with(context).load(R.mipmap.image2).into(holder.imageView);
        }
        if (position % 5 == 3) {
            Glide.with(context).load(R.mipmap.ic_launcher).into(holder.imageView);
        }
        if (position % 5 == 4) {
            Glide.with(context).load(R.mipmap.ic_launcher_round).into(holder.imageView);
        }
//        holder.imageView.setImageResource(ResUtils.getDrawable(context, "image" + position / 3));
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
