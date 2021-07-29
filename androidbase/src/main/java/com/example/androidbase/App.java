package com.example.androidbase;

import android.content.Context;

import com.lib.base.app.BaseApplication;
import com.lib.utils.Logger;
import com.lib.utils.app.AppUtils;

/**
 * @author :huangguofeng
 * date    :2021/7/26
 * package :com.example.androidbase
 * desc    :
 */
public class App extends BaseApplication {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        debug(this);
    }

    private void debug(Context context) {
        try {
            Logger.setDebug((Boolean) AppUtils.getMetaData(context, "DEBUG"));
            Logger.setRelease((Boolean) AppUtils.getMetaData(context, "RELEASE"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
