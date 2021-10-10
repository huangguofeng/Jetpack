package com.example.androidbase.thread;

import com.lib.utils.Logger;

/**
 * @author :huangguofeng
 * date    :2021/8/6
 * package :com.example.androidbase.thread
 * desc    :
 */
public class MyThread extends Thread {
    public MyThread() {
        super();
    }

    public MyThread(Runnable runnable) {
        super(runnable);
    }

    @Override
    public void run() {
        Logger.logInfo("自定义MyThread run方法执行了");
        super.run();
    }
}
