package com.lib.utils.app;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;

import com.lib.utils.Logger;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :huangguofeng
 * date    :2021/1/11
 * package :com.lib.utils.app
 * desc    :应用信息
 */
public class AppUtils {
    private static final String TAG = "[AppUtils]: ";

    /**
     * 从Manifest中获取mata-data值,获取的结果自行判空！！！！，然后转换成需要的指定类型的数据
     */
    public static Object getMetaData(Context context, String key) {
        if (context != null && !TextUtils.isEmpty(key)) {
            try {
                ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
                if (appInfo.metaData == null) {
                    return null;
                }
                return appInfo.metaData.get(key);
            } catch (Exception e) {
                Logger.logError(TAG + "获取app元数据属性" + key + "异常: " + e.getMessage(), e);
            }
        }
        return null;
    }

    /**
     * 获得应用签名
     *
     * @param ctx Context
     * @return 该app的签名 api 28以上可以使用
     */
    private static Signature[] getSignatures(Context ctx) {
        try {
            PackageManager manager = ctx.getPackageManager();
            PackageInfo packageInfo = null;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                packageInfo = manager.getPackageInfo(ctx.getPackageName(), PackageManager.GET_SIGNING_CERTIFICATES);
                Signature[] signatures = new Signature[0];
                /*
                 * 经历过二次签名，会有多个签名证书
                 */
                signatures = packageInfo.signingInfo.getSigningCertificateHistory();
                if (signatures != null) {
                    return signatures;
                } else {
                    /*
                     * 只有一次签名
                     */
                    signatures = packageInfo.signingInfo.getApkContentsSigners();
                    if (signatures != null) {
                        return signatures;
                    }
                }
            }
            return null;
        } catch (Exception e) {
            Logger.logError(TAG + "获取app签名异常: " + e.getMessage(), e);
        }
        return null;
    }


    /**
     * 获得应用签名
     *
     * @param ctx Context
     * @return 该app的签名 api 28以上可以使用
     */
    public static List<String> getSignature(Context ctx) {
        List<String> signaturesList = new ArrayList<>();
        Signature[] signatures = getSignatures(ctx);
        if (signatures != null) {
            for (Signature signature : signatures) {
                signaturesList.add(signature.toCharsString());
            }
        }
        return signaturesList;
    }

    public static List<String> getHashKey(Context ctx) {

        List<String> signaturesList = new ArrayList<>();
        Signature[] signatures = getSignatures(ctx);
        if (signatures != null) {
            for (Signature signature : signatures) {
                try {
                    MessageDigest md = MessageDigest.getInstance("SHA");
                    md.update(signature.toByteArray());
                    String hashKey = Base64.encodeToString(md.digest(), Base64.DEFAULT);
                    signaturesList.add(hashKey);
                } catch (Exception e) {
                    Logger.logError(TAG + "获取app的HashKey异常: " + e.getMessage(), e);
                }

            }
        }
        return signaturesList;
    }

    /**
     * 获取当前进程的名字
     */
    public static String getCurrentProcessName(Context cxt) {
        ActivityManager am = (ActivityManager) cxt.getSystemService(Context.ACTIVITY_SERVICE);
        try {
            List<ActivityManager.RunningAppProcessInfo> runningApps = am.getRunningAppProcesses();
            if (runningApps == null) {
                return "";
            }

            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningApps) {
                if (runningAppProcessInfo.pid == android.os.Process.myPid()) {
                    return runningAppProcessInfo.processName;
                }
            }
        } catch (Exception e) {
            Logger.logError(TAG + "获取app进程名异常: " + e.getMessage(), e);
        }
        return "";
    }

    /**
     * 判断当前是否是主线程
     */
    public static boolean isMainProcess(Context cxt) {
        return TextUtils.equals(cxt.getPackageName(), getCurrentProcessName(cxt));
    }

    /**
     * 获得程序版本号
     *
     * @param context Context
     * @return versionCode
     */
    public static long getVersionCode(Context context) {
        try {
            PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                return packageInfo.getLongVersionCode();
            }
        } catch (Exception e) {
            Logger.logError(TAG + "获取app版本号异常: " + e.getMessage(), e);
        }
        return -1;
    }

    /**
     * 获得当前版本名
     *
     * @param context Context
     * @return versionName
     */
    public static String getVersionName(Context context) {
        try {
            PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0);
            return packageInfo.versionName;
        } catch (Exception e) {
            Logger.logError(TAG + "获取app版本名异常: " + e.getMessage(), e);
        }
        return "";
    }

    /**
     * 获得当前APP名字
     *
     * @param context Context
     * @return app名字
     */
    public static String getAppName(Context context) {
        try {
            PackageManager pm = context.getApplicationContext().getPackageManager();
            ApplicationInfo applicationInfo = pm.getApplicationInfo(context.getPackageName(), 0);
            return (String) pm.getApplicationLabel(applicationInfo);
        } catch (Exception e) {
            Logger.logError(TAG + "获取app名字异常: " + e.getMessage(), e);
        }
        return "";
    }

    /**
     * 获得当前游戏程序包名
     *
     * @param context Context
     * @return packageName
     */
    public static String getPackageName(Context context) {
        try {
            PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0);
            return packageInfo.packageName;
        } catch (Exception e) {
            Logger.logError(TAG + "获取app包名异常: " + e.getMessage(), e);
        }
        return "";
    }

    /**
     * 判断当前应用是否正在运行。是否是前台进程。
     *
     * @param context Context
     * @return 是否运行
     */
    public static boolean isAppOnForeground(Context context) {
        try {
            ActivityManager am = (ActivityManager) context.getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
            String packageName = context.getApplicationContext().getPackageName();
            List<ActivityManager.RunningAppProcessInfo> appProcesses = am.getRunningAppProcesses();
            for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
                if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND && appProcess.processName.equals(packageName)) {
                    return true;
                }
            }
        } catch (Exception e) {
            Logger.logError(TAG + "获取app前后台状态异常: " + e.getMessage(), e);
        }
        return false;
    }
}
