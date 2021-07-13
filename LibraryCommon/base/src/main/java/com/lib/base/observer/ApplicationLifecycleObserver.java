package com.lib.base.observer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.lib.base.server.ApplicationLifecycleCallback;


/**
 * @author :huangguofeng
 * date    :2020/6/22
 * package :com.lib.base.observer
 * desc    :application生命周期观察者
 */
public class ApplicationLifecycleObserver implements LifecycleObserver {
    private final String TAG = "[ApplicationLifecycleObserver]: ";
    private ApplicationLifecycleCallback callback = null;

    public ApplicationLifecycleObserver(Lifecycle lifecycle) {
        lifecycle.addObserver(this);
    }

    public ApplicationLifecycleObserver(Lifecycle lifecycle, ApplicationLifecycleCallback applicationLifecycleCallback) {
        this.callback = applicationLifecycleCallback;
        lifecycle.addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate() {
        if (callback != null) {
            callback.create();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStart() {
        if (callback != null) {
            callback.start();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume() {
        if (callback != null) {
            callback.resume();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPause() {
        if (callback != null) {
            callback.pause();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop() {
        if (callback != null) {
            callback.stop();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy() {
        /*
         * 据说永不响应销毁事件
         */
        if (callback != null) {
            callback.destroy();
        }
    }
}
