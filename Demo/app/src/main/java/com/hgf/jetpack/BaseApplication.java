package com.hgf.jetpack;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.multidex.MultiDex;

import com.hgf.jetpack.lifecycle.observer.ApplicationLifecycleObserver;

/**
 * @author :huangguofeng
 * date    :2020-06-22
 * package :com.hgf.jetpack
 * desc    :BaseApplication
 */
public class BaseApplication extends Application {
    ApplicationLifecycleObserver lifecycleObserver;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        lifecycleObserver = new ApplicationLifecycleObserver(this, ProcessLifecycleOwner.get().getLifecycle());
    }
}
