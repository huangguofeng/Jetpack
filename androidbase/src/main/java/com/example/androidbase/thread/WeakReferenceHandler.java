package com.example.androidbase.thread;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * @author :huangguofeng
 * date    :2021/7/31
 * package :com.example.androidbase.thread
 * desc    :弱引用handler
 */
public class WeakReferenceHandler extends Handler {
    // 弱引用activity 避免内存泄露
    private WeakReference<Activity> mActivity;

    public WeakReferenceHandler(Activity activity) {
        mActivity = new WeakReference<>(activity);
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
    }
}
