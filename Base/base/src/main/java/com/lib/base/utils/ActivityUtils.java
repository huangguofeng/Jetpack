package com.lib.base.utils;

import android.app.Activity;
import android.content.res.Configuration;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleOwner;

import com.lib.base.observer.ApplicationLifecycleObserver;
import com.lib.base.server.ApplicationLifecycleCallback;
import com.lib.base.ui.BaseActivity;
import com.lib.base.ui.BaseViewModelActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author :huangguofeng
 * date    :2021/1/11
 * package :com.lib.base.utils
 * desc    :
 */
public class ActivityUtils {
    private static ActivityUtils utils;
    /**
     * 注册状态，每次启动仅限一次
     */
    private boolean state = false;
    /**
     * 全部activity
     */
    private static HashMap<String,Activity> activities = new HashMap<>();

    public static ActivityUtils get() {
        if (utils == null) {
            synchronized (ActivityUtils.class) {
                if (utils == null) {
                    utils = new ActivityUtils();
                }
            }
        }
        return utils;
    }

    /**
     * 添加activity
     *
     * @param activity activity
     */
    public void add(String name,Activity activity) {
        activities.put(name,activity);
    }

    /**
     * 添加activity
     *
     */
    public void remove(String name) {
        activities.remove(name);
    }

    /**
     * 移除全部activity
     */
    public void removeAll() {
        Iterator<Map.Entry<String, Activity>> iterable = activities.entrySet().iterator();
        while (iterable.hasNext()){
            Map.Entry<String,Activity> entry = iterable.next();
            if(!entry.getValue().isDestroyed() || !entry.getValue().isFinishing()){
                entry.getValue().finish();
            }
            iterable.remove();
        }
    }
    public void print(){
        Iterator<Map.Entry<String, Activity>> iterable = activities.entrySet().iterator();
        while (iterable.hasNext()){
            Map.Entry<String,Activity> entry = iterable.next();
            Log.i("jectpack","输出activity信息： name = "+entry.getKey()+"  ,value = "+entry.getValue());
        }
    }

}
