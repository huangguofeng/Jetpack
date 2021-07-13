package com.lib.base.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.multidex.MultiDex;

import com.lib.base.observer.ApplicationLifecycleObserver;
import com.lib.base.utils.ApplicationLifecycleUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * @author :huangguofeng
 * date    :2020-06-22
 * package :com.lib.base.app
 * desc    :BaseApplication
 */
public class BaseApplication extends Application {
    private static BaseApplication application;
    private ApplicationLifecycleObserver applicationLifecycleObserver;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        application = this;
        MultiDex.install(base);
        if (applicationLifecycleObserver == null) {
            applicationLifecycleObserver = new ApplicationLifecycleObserver(ProcessLifecycleOwner.get().getLifecycle());
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            closeAndroidDialog();
        }
        ApplicationLifecycleUtils.get().onCreate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        ApplicationLifecycleUtils.get().onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        ApplicationLifecycleUtils.get().onTrimMemory(level);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ApplicationLifecycleUtils.get().onTerminate();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        ApplicationLifecycleUtils.get().onConfigurationChanged(newConfig);
    }

    public static BaseApplication getApplication() {
        return application;
    }

    /**
     * Android P 后谷歌限制了开发者调用非官方公开API 方法或接口，也就是说，你用反射直接调用源码就会有这样的提示弹窗出现
     * android p会自动弹出，此方法可关闭dialog
     */
    private void closeAndroidDialog() {
        try {
            Class aClass = Class.forName("android.content.pm.PackageParser$Package");
            Constructor declaredConstructor = aClass.getDeclaredConstructor(String.class);
            declaredConstructor.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Class cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread");
            declaredMethod.setAccessible(true);
            Object activityThread = declaredMethod.invoke(null);
            Field mHiddenApiWarningShown = cls.getDeclaredField("mHiddenApiWarningShown");
            mHiddenApiWarningShown.setAccessible(true);
            mHiddenApiWarningShown.setBoolean(activityThread, true);
        } catch (Exception e) {
        }
    }
}
