package com.lib.base.utils;

import android.content.res.Configuration;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleOwner;

import com.lib.base.observer.ApplicationLifecycleObserver;
import com.lib.base.server.ApplicationLifecycleCallback;

import java.util.HashMap;

/**
 * @author :huangguofeng
 * date    :2021/1/11
 * package :com.lib.base.utils
 * desc    :对外提供应用级生命周期注册监听
 */
public class ApplicationLifecycleUtils {
    private static ApplicationLifecycleUtils applicationLifecycleUtils;
    /**
     * 注册状态，每次启动仅限一次
     */
    private boolean state = false;
    /**
     * 上层库接收生命周期回调的callback集合
     */
    private static HashMap<String, ApplicationLifecycleCallback> callbacks = new HashMap<>();

    public static ApplicationLifecycleUtils get() {
        if (applicationLifecycleUtils == null) {
            synchronized (ApplicationLifecycleUtils.class) {
                if (applicationLifecycleUtils == null) {
                    applicationLifecycleUtils = new ApplicationLifecycleUtils();
                }
            }
        }
        return applicationLifecycleUtils;
    }

    /**
     * 注册应用级生命周期回调
     *
     * @param tag      回调标记，区分来源，非空，防止多个模块同时使用，多次注册同一个tag，后注册的无效
     * @param callback 回调
     */
    public synchronized void registerLifecycleCallback(String tag, ApplicationLifecycleCallback callback) {
        if (tag != null && callback != null) {
            if (!callbacks.containsKey(tag)) {
                callbacks.put(tag, callback);
            }
        }
        registerLifecycleCallback();
    }

    /**
     * 对外提供生命周期回调设置，实现同步锁，处理多次调用
     */
    private synchronized void registerLifecycleCallback() {
        if (!state) {
            synchronized (ApplicationLifecycleUtils.class) {
                if (!state) {
                    state = true;
                    Lifecycle lifecycle = ProcessLifecycleOwner.get().getLifecycle();
                    lifecycle.addObserver(new ApplicationLifecycleObserver(lifecycle, applicationLifecycleCallback));
                }
            }
        }
    }

    /**
     * 接收应用的生命周期回调,并分发给所以的注册者
     */
    private ApplicationLifecycleCallback applicationLifecycleCallback = new ApplicationLifecycleCallback() {
        @Override
        public void create() {
            for (String tag : callbacks.keySet()) {
                if (callbacks.get(tag) != null) {
                    callbacks.get(tag).create();
                }
            }
        }

        @Override
        public void start() {
            for (String tag : callbacks.keySet()) {
                if (callbacks.get(tag) != null) {
                    callbacks.get(tag).start();
                }
            }
        }

        @Override
        public void resume() {
            for (String tag : callbacks.keySet()) {
                if (callbacks.get(tag) != null) {
                    callbacks.get(tag).resume();
                }
            }
        }

        @Override
        public void pause() {
            for (String tag : callbacks.keySet()) {
                if (callbacks.get(tag) != null) {
                    callbacks.get(tag).pause();
                }
            }
        }

        @Override
        public void stop() {
            for (String tag : callbacks.keySet()) {
                if (callbacks.get(tag) != null) {
                    callbacks.get(tag).stop();
                }
            }
        }

        @Override
        public void destroy() {
            for (String tag : callbacks.keySet()) {
                if (callbacks.get(tag) != null) {
                    callbacks.get(tag).destroy();
                }
            }
        }

        @Override
        public void onCreate() {
            for (String tag : callbacks.keySet()) {
                if (callbacks.get(tag) != null) {
                    callbacks.get(tag).destroy();
                }
            }
        }

        @Override
        public void onLowMemory() {
            for (String tag : callbacks.keySet()) {
                if (callbacks.get(tag) != null) {
                    callbacks.get(tag).destroy();
                }
            }
        }

        @Override
        public void onTrimMemory(int level) {
            for (String tag : callbacks.keySet()) {
                if (callbacks.get(tag) != null) {
                    callbacks.get(tag).destroy();
                }
            }
        }

        @Override
        public void onTerminate() {
            for (String tag : callbacks.keySet()) {
                if (callbacks.get(tag) != null) {
                    callbacks.get(tag).destroy();
                }
            }
        }

        @Override
        public void onConfigurationChanged(@NonNull Configuration newConfig) {
            for (String tag : callbacks.keySet()) {
                if (callbacks.get(tag) != null) {
                    callbacks.get(tag).destroy();
                }
            }
        }
    };


    public void onCreate() {
        if (applicationLifecycleCallback != null) {
            applicationLifecycleCallback.onCreate();
        }
    }


    public void onLowMemory() {
        if (applicationLifecycleCallback != null) {
            applicationLifecycleCallback.onLowMemory();
        }
    }


    public void onTrimMemory(int level) {
        if (applicationLifecycleCallback != null) {
            applicationLifecycleCallback.onTrimMemory(level);
        }
    }


    public void onTerminate() {
        if (applicationLifecycleCallback != null) {
            applicationLifecycleCallback.onTerminate();
        }
    }


    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        if (applicationLifecycleCallback != null) {
            applicationLifecycleCallback.onConfigurationChanged(newConfig);
        }
    }
}
