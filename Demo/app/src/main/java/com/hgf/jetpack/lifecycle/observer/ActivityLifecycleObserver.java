package com.hgf.jetpack.lifecycle.observer;

import android.app.Activity;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.hgf.jetpack.lifecycle.callback.LifecycleCallback;
import com.hgf.jetpack.utils.ILog;

/**
 * @author :huangguofeng
 * date    :2020/7/1
 * package :com.hgf.jetpack.lifecycle.observer
 * desc    :activity生命周期观察者
 */
public class ActivityLifecycleObserver implements LifecycleObserver {
    private String TAG = "ActivityLifecycleObserver :";
    private boolean enable = false;
    private Lifecycle lifecycle = null;
    private Activity activity = null;
    private LifecycleCallback callback = null;

    public ActivityLifecycleObserver(Activity activity, Lifecycle lifecycle) {
        TAG = TAG + activity.getClass().getSimpleName() + " :";
        if (this.activity != null) {
            ILog.logError(TAG + "重复实例化");
            return;
        }
        this.activity = activity;
        this.lifecycle = lifecycle;
        lifecycle.addObserver(this);
        if (!enable) {
            setEnable(true);
        }
        ILog.logInfo(TAG + "addObserver");
    }

    public ActivityLifecycleObserver(Activity activity, Lifecycle lifecycle, LifecycleCallback callback) {
        TAG = TAG + activity.getClass().getSimpleName() + " :";
        if (this.activity != null) {
            ILog.logError(TAG + "重复实例化");
            return;
        }
        this.activity = activity;
        this.lifecycle = lifecycle;
        this.callback = callback;
        lifecycle.addObserver(this);
        if (!enable) {
            setEnable(true);
        }
        ILog.logInfo(TAG + "addObserver");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate() {
        if (enable) {
            ILog.logInfo(TAG + "onCreate");
            if (callback != null) {
                callback.create();
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy() {
        if (enable) {
            ILog.logInfo(TAG + "onDestroy");
            if (callback != null) {
                callback.destroy();
            }
            setEnable(false);
        }
        lifecycle.removeObserver(this);
        lifecycle = null;
        activity = null;
        ILog.logInfo(TAG + "removeObserver");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStart() {
        if (enable) {
            ILog.logInfo(TAG + "onStart");
            if (callback != null) {
                callback.start();
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop() {
        if (enable) {
            ILog.logInfo(TAG + "onStop");
            if (callback != null) {
                callback.stop();
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume() {
        if (enable) {
            ILog.logInfo(TAG + "onResume");
            if (callback != null) {
                callback.resume();
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPause() {
        if (enable) {
            ILog.logInfo(TAG + "onPause");
            if (callback != null) {
                callback.pause();
            }
        }
    }

    public boolean isEnable() {
        ILog.logInfo(TAG + " " + enable);
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
