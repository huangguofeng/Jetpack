package com.hgf.jetpack.lifecycle.observer;

import android.app.Application;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.hgf.jetpack.utils.ILog;

/**
 * @author :huangguofeng
 * date    :2020/6/22
 * package :com.hgf.jetpack.lifecycle.observer
 * desc    :application生命周期观察者
 */
public class ApplicationLifecycleObserver implements LifecycleObserver {
    private final String TAG = "ApplicationLifecycleObserver :";
    private Lifecycle lifecycle = null;
    private Application application = null;

    public ApplicationLifecycleObserver(Application application, Lifecycle lifecycle) {
        this.application = application;
        this.lifecycle = lifecycle;
        lifecycle.addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate() {
        ILog.logDebug(TAG + "App Create");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStart() {
        ILog.logDebug(TAG + "App Start");
        ILog.logDebug(TAG + "App Start，addObserver");
        lifecycle.addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume() {
        ILog.logDebug(TAG + "App Resume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPause() {
        ILog.logDebug(TAG + "App Pause");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop() {
        ILog.logDebug(TAG + "App Stop");
    }
}
