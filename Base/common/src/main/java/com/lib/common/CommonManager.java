package com.lib.common;

import com.lib.utils.device.NetworkUtils;

/**
 * @author :huangguofeng
 * date    :2021/2/5
 * package :com.lib.sp
 * desc    :轻量高效的kv储存读取工具
 */
public class CommonManager {
    private static CommonManager manager;
    private static final String TAG = "[CommonManager]: ";

    public static void get() {
        if (manager == null) {
            synchronized (CommonManager.class) {
                if (manager == null) {
                    manager = new CommonManager();
                }
            }
        }
    }

    /**
     * 资源释放
     */
    public void release() {
        NetworkUtils.close();
    }
}
