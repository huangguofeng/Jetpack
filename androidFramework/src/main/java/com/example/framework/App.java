package com.example.framework;

import android.content.Context;

import com.lib.base.app.BaseApplication;
import com.lib.utils.Logger;
import com.lib.utils.app.AppUtils;

/**
 * @author :huangguofeng
 * date    :2021/8/9
 * package :com.example.framework
 * desc    :
 */
public class App extends BaseApplication {
    private static Context context;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        debug(this);
        context = base;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
    
    private void debug(Context context) {
        try {
            Logger.setDebug((Boolean) AppUtils.getMetaData(context, "DEBUG"));
            Logger.setRelease((Boolean) AppUtils.getMetaData(context, "RELEASE"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Context getContext() {
        return context;
    }

}
