package com.lib.utils.device;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.lib.utils.Logger;
import com.lib.utils.file.MmKvUtil;
import com.lib.utils.permission.PermissionUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author :huangguofeng
 * date    :2021/1/11
 * package :com.lib.utils.device
 * desc    :设备硬件信息
 */
public class DeviceUtils {
    private static final String TAG = "[DeviceUtils]: ";
    private static final String DEVICE_ID = "deviceId";

    /**
     * 各自安卓设备id
     */
    private static String androidId;
    private static String GoogleAdId;
    private static String uuid;
    private static String imei;
    /**
     * GoogleAdId 获取状态标记
     */
    private static boolean GoogleAdIdState = false;

    /**
     * 最终采用的设备id
     */
    private static String deviceId;
    private static final String DEFAULT_MAC_ADDRESS = "02:00:00:00:00:00";
    private static JSONObject deviceInfo;

    /**
     * 获取国家代码
     *
     * @param context Context
     * @return Country Code
     */
    public static String getCountryCode(Context context) {
        if (context == null) {
            return null;
        }
        Locale locale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            locale = context.getResources().getConfiguration().getLocales().get(0);
        } else {
            locale = context.getResources().getConfiguration().locale;
        }
        Logger.logDebug(TAG + "获取设备使用的国家代码：" + locale.getCountry());
        return locale.getCountry();
    }

    /**
     * 获取语言
     *
     * @param context Context
     * @return Language Code
     */
    public static String getLanguageCode(Context context) {
        if (context == null) {
            return null;
        }
        Locale locale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            locale = context.getResources().getConfiguration().getLocales().get(0);
        } else {
            locale = context.getResources().getConfiguration().locale;
        }
        Logger.logDebug(TAG + "获取设备使用的语言代码：" + locale.getLanguage());
        return locale.getLanguage();
    }

    /**
     * 获取手机品牌
     *
     * @return 手机品牌
     */
    public static String getPhoneBrand() {
        return Build.BRAND;
    }

    /**
     * 获取手机型号
     *
     * @return 手机型号
     */
    public static String getPhoneVersion() {
        return Build.MODEL;
    }

    /**
     * 获取手机版本
     *
     * @return 系统版本
     */
    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    /**
     * 获取MAC地址
     *
     * @param context Context
     * @return mac address
     */
    @SuppressLint("HardwareIds")
    public static String getMacAddress(Context context) {
        if (context == null) {
            return null;
        }
        String macStr = null;
        WifiManager wifi = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        try {
            WifiInfo info = wifi.getConnectionInfo();
            macStr = info.getMacAddress();
        } catch (Exception e) {
            Logger.logError(TAG + "获取mac地址错误：" + e.getMessage(), e);
        }

        if (DEFAULT_MAC_ADDRESS.equals(macStr)) {
            macStr = null;
        }
        return macStr;
    }


    /**
     * 7.0 以上 遍历循环所有的网络接口，找到接口是 wlan0
     * 必须的权限 <uses-permission android:name="android.permission.INTERNET" />
     *
     * @return MAC地址
     */
    public static String getMacFromHardware() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!"wlan0".equalsIgnoreCase(nif.getName())) {
                    continue;
                }

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    res1.append(String.format("%02X:", b));
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DEFAULT_MAC_ADDRESS;
    }

    /**
     * 这个方法是耗时的，不能在主线程调用
     *
     * @param context Context
     * @return GoogleAdId
     */
    public static String getGoogleAdId(Context context) {
        if (context == null) {
            return null;
        }
        if (TextUtils.isEmpty(GoogleAdId)) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                Logger.logError(TAG + "主线程不允许获取GoogleAdId");
                return null;
            }
            try {
                PackageManager pm = context.getPackageManager();
                pm.getPackageInfo("com.android.vending", 0);
            } catch (Exception e) {
                Logger.logError(TAG + "getPackageInfo: com.android.vending 错误：" + e.getMessage(), e);
                return null;
            }
            AdvertisingConnection connection = new AdvertisingConnection();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (context.bindService(intent, connection, Context.BIND_AUTO_CREATE)) {
                try {
                    AdvertisingInterface adInterface = new AdvertisingInterface(connection.getBinder());
                    GoogleAdId = adInterface.getId();
                    Logger.logDebug(TAG + "获取到的 GoogleAdId：" + GoogleAdId);
                    GoogleAdIdState = true;
                    return GoogleAdId;
                } catch (Exception e) {
                    Logger.logError(TAG + "获取GoogleAdId错误：" + e.getMessage(), e);
                } finally {
                    context.unbindService(connection);
                }
            }
        }
        Logger.logDebug(TAG + "getGoogleAdId 即将返回：" + GoogleAdId);
        return GoogleAdId;
    }

    /**
     * 获取 Android ID:有时为null。恢复出厂设置会改变该值。并且手机被Root过的话，这个ID也可以被任意改变
     *
     * @param context Context
     * @return android id
     */
    public static String getAndroidId(Context context) {
        if (context == null) {
            return null;
        }
        if (TextUtils.isEmpty(androidId)) {
            androidId = Settings.System.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        }
        Logger.logDebug(TAG + "获取到的AndroidId: " + androidId);
        return androidId;
    }

    /**
     * 获取 UUID
     *
     * @return 随机码UUID
     */
    public static String getUuId() {
        if (TextUtils.isEmpty(uuid)) {
            uuid = java.util.UUID.randomUUID().toString();
        }
        Logger.logDebug(TAG + "获取到UUID: " + uuid);
        return uuid;
    }

    /**
     * 获取 imei
     *
     * @return imei
     */
    @SuppressLint("MissingPermission")
    public static String getImei(Context context) {
        if (TextUtils.isEmpty(imei)) {
            if (PermissionUtils.checkPermission(context, Manifest.permission.READ_PHONE_STATE)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                try {
                    if (telephonyManager != null) {
                        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) {
                            imei = telephonyManager.getDeviceId();
                            if (TextUtils.isEmpty(imei) || "0".equals(imei) || "000000000000000".equals(imei)) {
                                imei = "";
                            }
                        }
                    }
                } catch (Exception e) {
                    Logger.logDebug(TAG + "获取imei异常: " + e.getMessage());
                }
            }
        }
        Logger.logDebug(TAG + "获取到imei: " + imei);
        return imei;
    }

    /**
     * 获取设备ID
     * 读取策略：读取SP
     * 生成策略：IMEI > AndroidID > UUID
     *
     * @param ctx Context
     * @return 可以的话返回曾经的设备ID, 否则返回新策略生成的
     */
    public static String getDeviceId(Context ctx) {
        if (TextUtils.isEmpty(deviceId)) {
            // 优先读取缓存
            deviceId = getId();
            // 生成逻辑
            if (TextUtils.isEmpty(deviceId)) {
                // 读取IMEI
                deviceId = getImei(ctx);

                // 读取Android ID
                if (TextUtils.isEmpty(deviceId)) {
                    deviceId = getAndroidId(ctx);
                }

                // 读取UUID
                if (TextUtils.isEmpty(deviceId)) {
                    deviceId = getUuId();
                }

                // 保存仅仅一次
                saveId(deviceId);
            }
        }
        Logger.logDebug("获取到的deviceId = " + deviceId);
        return deviceId;
    }

    /**
     * 重置设备id
     */
    public static void resetDeviceId() {
        deviceId = null;
        MmKvUtil.put(DEVICE_ID, "");
    }

    private static void saveId(String deviceId) {
        MmKvUtil.put(DEVICE_ID, deviceId);
    }

    private static String getId() {
        return MmKvUtil.getString(DEVICE_ID);
    }

    /**
     * platform         ：平台安卓
     * originalVersion  ：系统原生版本 可能是API版本：27 28 29，也可能是安卓系统版本：安卓7 8 9 10
     * osVersion        ：系统自定义UI框架版本 例：EmotionUI_10.0.0 ，小米MIUI，ColorOs1.0等
     * deviceType       ：设备型号 CLT-AL00
     * manufacturer     ：设备品牌：使用硬件制造商属性，例：HUAWEI HONER VIVO 步步高
     * simState         ：是否有手机卡 true or false
     * operator         ：手机卡运营商名字 CMCC CUCC CTCC
     */
    public static synchronized JSONObject getDeviceInfo(Context context) {
        if (deviceInfo != null) {
            return deviceInfo;
        }
        deviceInfo = new JSONObject();
        try {
            deviceInfo.put("platform", "Android");
            deviceInfo.put("originalVersion", Build.VERSION.SDK_INT + "");
            deviceInfo.put("osVersion", getOsVersion((Build.BRAND + Build.MANUFACTURER).toUpperCase()));
            deviceInfo.put("deviceType", Build.MODEL + "");
            deviceInfo.put("manufacturer", Build.MANUFACTURER + "");
            deviceInfo.put("simState", NetworkUtils.hasSim(context));
            deviceInfo.put("operator", NetworkUtils.getSimOperatorName(context));
        } catch (JSONException e) {
            Logger.logError(TAG + "获取设备信息异常：" + e.getMessage(), e);
        }
        return deviceInfo;
    }

    /*
     * Build.BRAND 系统定制商 例如：荣耀 华为 oppo
     * Build.MODEL 设备型号
     * Build.MANUFACTURER 硬件制造商
     * Build.VERSION.SDK_INT 原生版本
     */
    /**
     * ROM类型
     */
    private static final String ROM_MI = "XIAOMI";
    private static final String ROM_HW = "HUAWEI";
    private static final String ROM_MZ = "MEIZU";
    private static final String ROM_OPPO = "OPPO";
    private static final String ROM_VIVO = "VIVO";
    private static final String ROM_FLYME = "FLYME";
    private static final String ROM_QIKU = "QIKU";
    private static final String ROM_SMARTISAN = "SMARTISAN";
    /**
     * 不同厂商自定义UI框架属性key
     */
    private static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    private static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    private static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
    private static final String KEY_VERSION_OPPO = "ro.build.version.opporom";
    private static final String KEY_VERSION_VIVO = "ro.vivo.os.version";
    /**
     * 当前设备的自定义UI框架版本号
     */
    private static String osVersion;

    /**
     * 获取不同手机厂商系统的自定义UI版本
     *
     * @param phoneType 厂商系统型号
     */
    public static String getOsVersion(String phoneType) {
        if (osVersion != null) {
            return osVersion;
        }
        if (phoneType.contains(ROM_MI)) {
            osVersion = getProp(KEY_VERSION_MIUI);
        } else if (phoneType.contains(ROM_HW)) {
            osVersion = getProp(KEY_VERSION_EMUI);
        } else if (phoneType.contains(ROM_OPPO)) {
            osVersion = getProp(KEY_VERSION_OPPO);
        } else if (phoneType.contains(ROM_VIVO)) {
            osVersion = getProp(KEY_VERSION_VIVO);
        } else if (phoneType.contains(ROM_SMARTISAN)) {
            osVersion = getProp(KEY_VERSION_SMARTISAN);
        } else {
            if (Build.DISPLAY.toUpperCase().contains(ROM_FLYME)) {
                osVersion = ROM_FLYME;
            } else {
                osVersion = Build.VERSION.INCREMENTAL;
            }
        }
        Logger.logDebug(TAG + "设备类型：" + phoneType + "，自定义UI框架版本：" + osVersion);
        return osVersion;
    }

    /**
     * 获取手机内置系统属性的值
     *
     * @param name 要获取的属性名
     */
    private static String getProp(String name) {
        String line = null;
        BufferedReader input = null;
        try {
            Process p = Runtime.getRuntime().exec("getprop " + name);
            input = new BufferedReader(new InputStreamReader(p.getInputStream()), 1024);
            line = input.readLine();
            input.close();
        } catch (IOException ex) {
            return null;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return line;
    }

    /**
     * 谷歌AdId链接服务
     */
    private static final class AdvertisingConnection implements ServiceConnection {
        private final LinkedBlockingQueue<IBinder> queue = new LinkedBlockingQueue<>(1);
        boolean retrieved = false;

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            try {
                this.queue.put(service);
            } catch (InterruptedException localInterruptedException) {
                localInterruptedException.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }

        public IBinder getBinder() throws InterruptedException {
            if (this.retrieved) {
                throw new IllegalStateException();
            }
            this.retrieved = true;
            return this.queue.take();
        }
    }

    private static final class AdvertisingInterface implements IInterface {
        private IBinder binder;

        public AdvertisingInterface(IBinder pBinder) {
            binder = pBinder;
        }

        @Override
        public IBinder asBinder() {
            return binder;
        }

        public String getId() throws RemoteException {
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            String id;
            try {
                data.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                binder.transact(1, data, reply, 0);
                reply.readException();
                id = reply.readString();
            } finally {
                reply.recycle();
                data.recycle();
            }
            return id;
        }


        public boolean isLimitAdTrackingEnabled(boolean paramBoolean) throws RemoteException {
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            boolean limitAdTracking;
            try {
                data.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                data.writeInt(paramBoolean ? 1 : 0);
                binder.transact(2, data, reply, 0);
                reply.readException();
                limitAdTracking = 0 != reply.readInt();
            } finally {
                reply.recycle();
                data.recycle();
            }
            return limitAdTracking;
        }
    }

    /**
     * GoogleAdId 获取的状态
     */
    public static boolean isGoogleAdIdSuccess() {
        return GoogleAdIdState;
    }
}
