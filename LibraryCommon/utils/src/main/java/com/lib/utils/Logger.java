package com.lib.utils;

import android.text.TextUtils;
import android.util.Log;

/**
 * @author :huangguofeng
 * date    :2021/1/10
 * package :com.lib.utils
 * desc    :日志控制
 */
public class Logger {
    private static final String TAG = "Jectpack";
    private static boolean debug = false;
    private static boolean release = false;

    public static boolean isRelease() {
        return release;
    }

    public static void setRelease(boolean release) {
        Logger.release = release;
    }

    public static boolean isDebug() {
        return debug;
    }

    public static void setDebug(boolean state) {
        Logger.debug = state;
    }

    public static void logVerbose(String msg) {
        log(null, Log.VERBOSE, msg + "", null);
    }

    public static void logVerbose(String tag, String msg) {
        log(tag, Log.VERBOSE, msg + "", null);
    }


    public static void logInfo(String msg) {
        log(null, Log.INFO, msg + "", null);
    }

    public static void logInfo(String tag, String msg) {
        log(tag, Log.INFO, msg + "", null);
    }


    public static void logDebug(String msg) {
        log(null, Log.DEBUG, msg + "", null);
    }

    public static void logDebug(String tag, String msg) {
        log(tag, Log.DEBUG, msg + "", null);
    }


    public static void logWarn(String msg) {
        log(null, Log.WARN, msg + "", null);
    }

    public static void logWarn(String msg, Exception e) {
        log(null, Log.WARN, msg + "", e);
    }

    public static void logWarn(String tag, String msg) {
        log(tag, Log.WARN, msg + "", null);
    }

    public static void logWarn(String tag, String msg, Exception e) {
        log(tag, Log.WARN, msg + "", e);
    }

    public static void logError(String msg) {
        log(null, Log.ERROR, msg + "", null);
    }

    public static void logError(String msg,Exception e) {
        log(null, Log.ERROR, msg + "", e);
    }

    public static void logError(String tag, String msg) {
        log(tag, Log.ERROR, msg + "", null);
    }

    public static void logError(String tag, String msg, Exception e) {
        log(tag, Log.ERROR, msg + "", e);
    }


    private static void log(String tag, int level, String msg, Exception e) {
        switch (level) {
            case Log.INFO:
                if (release) {
                    Log.i(TextUtils.isEmpty(tag) ? TAG : tag, msg);
                }
                break;
            case Log.DEBUG:
                if (release && debug) {
                    Log.d(TextUtils.isEmpty(tag) ? TAG : tag, msg);
                }
                break;
            case Log.WARN:
                if (release && debug) {
                    Log.w(TextUtils.isEmpty(tag) ? TAG : tag, msg, e);
                }
                break;
            case Log.ERROR:
                if (release && debug) {
                    Log.e(TextUtils.isEmpty(tag) ? TAG : tag, msg, e);
                }
                break;
            default:
                Log.v(TextUtils.isEmpty(tag) ? TAG : tag, msg);
                break;
        }
    }

}
