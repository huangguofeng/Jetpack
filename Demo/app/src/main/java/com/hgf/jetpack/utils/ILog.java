package com.hgf.jetpack.utils;

import android.util.Log;

/**
 * @author :huangguofeng
 * date    :2020/6/22
 * package :com.hgf.jetpack.utils
 * desc    :日志控制
 */
public class ILog {
    private static final String TAG = "hgf-jetpack";
    public static boolean STATUS = true;
    public static final int VERBOSE = 0;
    public static final int INFO = 1;
    public static final int DEBUG = 2;
    public static final int WARN = 3;
    public static final int ERROR = 4;

    public static boolean isSTATUS() {
        return STATUS;
    }

    public static void setSTATUS(boolean STATUS) {
        ILog.STATUS = STATUS;
    }

    public static void lofVerbose(String msg) {
        log(VERBOSE, msg + "");
    }

    public static void logInfo(String msg) {
        log(INFO, msg + "");
    }

    public static void logDebug(String msg) {
        log(DEBUG, msg + "");
    }

    public static void logWarn(String msg) {
        log(WARN, msg + "");
    }

    public static void logError(String msg) {
        log(ERROR, msg + "");
    }

    private static void log(int type, String msg) {
        if (STATUS) {
            switch (type) {
                case 0:
                    Log.v(TAG, msg);
                    break;
                case 1:
                    Log.i(TAG, msg);
                    break;
                case 2:
                    Log.d(TAG, msg);
                    break;
                case 3:
                    Log.w(TAG, msg);
                    break;
                case 4:
                    Log.e(TAG, msg);
                    break;
                default:
                    break;
            }
        }
    }

}
