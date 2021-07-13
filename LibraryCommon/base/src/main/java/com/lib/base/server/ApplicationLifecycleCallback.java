package com.lib.base.server;

import android.content.res.Configuration;

import androidx.annotation.NonNull;

/**
 * @author :huangguofeng
 * date    :2020/7/1
 * package :com.lib.base.server
 * desc    :应用生命周期观察者对外回调
 */
public interface ApplicationLifecycleCallback {

    /**
     * 对应生命周期onCreate
     */
    void create();

    /**
     * 对应生命周期onStart
     */
    void start();

    /**
     * 对应生命周期onResume
     */
    void resume();

    /**
     * 对应生命周期onPause
     */
    void pause();

    /**
     * 对应生命周期onStop
     */
    void stop();

    /**
     * 对应生命周期onDestroy
     */
    void destroy();

    /**
     * 对应application生命周期onCreate
     */
    void onCreate();

    /**
     * 对应application生命周期onLowMemory
     */
    void onLowMemory();

    /**
     * 对应application生命周期onTrimMemory
     *
     * @param level 当前内存的使用等级，可以根据等级选择是否释放内存，参考类：android.content.ComponentCallbacks2 对内存等级的划分
     */
    void onTrimMemory(int level);

    /**
     * 对应application生命周期onTerminate
     */
    void onTerminate();

    /**
     * 对应application生命周期onConfigurationChanged
     *
     * @param newConfig 屏幕旋转后系统触发方法，注意需要在manifest配置 configChanges 属性
     */
    void onConfigurationChanged(@NonNull Configuration newConfig);
}
