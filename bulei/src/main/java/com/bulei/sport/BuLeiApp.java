package com.bulei.sport;

import android.content.Context;

import com.lib.base.app.BaseApplication;
import com.lib.utils.Logger;
import com.lib.utils.app.AppUtils;

/**
 * @author :huangguofeng
 * date    :2021/3/9
 * package :com.example.myapplication
 * desc    :
 */
public class BuLeiApp extends BaseApplication {

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

    @Override
    protected boolean isDebug() {
        return true;
    }
}
