package com.hgf.jetpack.lifecycle.callback;

/**
 * @author :huangguofeng
 * date    :2020/7/1
 * package :com.hgf.jetpack.lifecycle.callback
 * desc    :生命周期观察者对外回调
 */
public interface LifecycleCallback {

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
}
