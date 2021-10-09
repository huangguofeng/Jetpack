package com.lib.utils.device;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;

import androidx.annotation.RequiresApi;

import com.lib.utils.Logger;
import com.lib.utils.permission.PermissionUtils;

/**
 * @author :huangguofeng
 * date    :2021/1/11
 * package :com.lib.utils.device
 * desc    :设备网络信息
 */
public class NetworkUtils {
    private static final String TAG = "[NetworkUtils]: ";
    private static Context c;
    /**
     * 网络连接是否可用
     */
    private static boolean netAvailable = false;
    /**
     * wifi状态
     */
    private static boolean wifiState = false;
    /**
     * 数据网状态
     */
    private static boolean mobileNetWorkState = false;
    /**
     * 网络监控注册状态
     */
    private static boolean registerState = false;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private static ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() {
        /**
         * 网络连接并且可用时回调
         */
        @Override
        public void onAvailable(Network network) {
            super.onAvailable(network);
            netAvailable = true;
            Logger.logDebug(TAG + "网络onAvailable：" + network.toString());
        }

        /**
         * 网络即将断开时触发
         */
        @Override
        public void onLosing(Network network, int maxMsToLive) {
            super.onLosing(network, maxMsToLive);
            Logger.logDebug(TAG + "网络onLosing,最大保留时间：" + maxMsToLive);
        }

        /**
         * 网络已经断开时触发
         */
        @Override
        public void onLost(Network network) {
            super.onLost(network);
            netAvailable = false;
            Logger.logDebug(TAG + "网络onLost");
        }

        /**
         * 指定的超时时间内找不到网络时触发
         */
        @Override
        public void onUnavailable() {
            super.onUnavailable();
            Logger.logDebug(TAG + "网络onUnavailable");
        }

        /**
         * 建议只监测onCapabilitiesChanged(network: Network, networkCapabilities: NetworkCapabilities)
         * 因为别的回调在连接上VPN后，在APP使用过程中就完全不会被调用，TODO：待验证
         *
         * networkCapabilities.hasCapability()方法参数:
         * NET_CAPABILITY_INTERNET：表示是否连接到互联网，即是否连接上了WIFI或者移动蜂窝网络，这个为TRUE不一定能正常上网
         * NET_CAPABILITY_VALIDATED：表示是否确实能和连接的互联网通信，这个为TRUE，才是真的能上网
         *
         * networkCapabilities.hasTransport()方法参数：
         * TRANSPORT_CELLULAR：表示当前接入的是否是蜂窝网络
         * TRANSPORT_WIFI：表明当前接入的是WIFI网络，还有一些别的蓝牙网络，有线网络等等可以直接查看文档或源码了解
         */
        @Override
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
            Logger.logInfo(TAG + "onCapabilitiesChanged 是否连接上了WIFI或者移动蜂窝网络：" + networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET));

            netAvailable = networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED);
            mobileNetWorkState = networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR);
            wifiState = networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI);

            Logger.logDebug(TAG + "onCapabilitiesChanged 是否真的能上网：" + netAvailable);
            Logger.logDebug(TAG + "onCapabilitiesChanged 当前接入的是否是蜂窝网络：" + mobileNetWorkState);
            Logger.logDebug(TAG + "onCapabilitiesChanged 当前接入的是WIFI型网络：" + wifiState);

            Logger.logDebug(TAG + "onCapabilitiesChanged 网络功能状态：" + networkCapabilities.toString());
        }

        @Override
        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            super.onLinkPropertiesChanged(network, linkProperties);
            Logger.logDebug(TAG + "onLinkPropertiesChanged 链接状态：" + linkProperties.toString());
        }

    };

    /**
     * 初始化:异步注册网络状态回调，监控网络状态变化，需要较高的安卓版本
     * 检测网络连接状态是否可用,异步模式
     * 注意：manifest需要配置网络权限android.permission.ACCESS_NETWORK_STATE
     */
    @SuppressLint("MissingPermission")
    public static void init(Context context) {
        c = context;
        if (PermissionUtils.checkPermission(context, Manifest.permission.ACCESS_NETWORK_STATE) && Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            if (registerState) {
                Logger.logWarn("不允许重复初始化网络状态监听");
                return;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            connectivityManager.registerDefaultNetworkCallback(networkCallback);
            registerState = true;
            Logger.logInfo("7.0以上设备: 初始化网络状态监听");
        } else {
            Logger.logError("Manifest清单缺少ACCESS_NETWORK_STATE权限,或者当前设备低于7.0,所以无法启动ConnectivityManager网络监控");
        }
    }

    /**
     * 断开监听器，一个手机最多允许100个监听器存在
     */
    public static void close() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && registerState) {
            ConnectivityManager connectivityManager = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
            connectivityManager.unregisterNetworkCallback(networkCallback);
        }
    }

    /**
     * 网络是否真实可用
     */
    public static boolean isNetAvailable() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return netAvailable;
        } else {
            ConnectivityManager cm = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = cm.getActiveNetworkInfo();
            return mNetworkInfo.isAvailable();
        }
    }

    /**
     * wifi是否链接
     */
    public static boolean isWifiState() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return wifiState;
        } else {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mWiFiNetworkInfo = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            return mWiFiNetworkInfo.isAvailable();
        }
    }

    /**
     * 数据网是否接入
     */
    public static boolean isMobileNetWorkState() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return mobileNetWorkState;
        } else {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mMobileNetworkInfo = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            return mMobileNetworkInfo.isAvailable();
        }
    }

    /**
     * 检查手机是否有sim卡
     *
     * @return true 或 false
     */
    public static boolean hasSim(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getSimState() == TelephonyManager.SIM_STATE_READY;
    }

    /**
     * 获取手机无线电类型 CDMA FDD-LTE GSM TD-LTE
     *
     * @return 0 1 2 3
     * TelephonyManager.PHONE_TYPE_NONE  0
     * TelephonyManager.PHONE_TYPE_CDMA  2
     * TelephonyManager.PHONE_TYPE_GSM  1
     * TelephonyManager.PHONE_TYPE_SIP  3
     */
    public static int getPhoneType(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getPhoneType();
    }

    /**
     * 获取注册的运营商数字代码
     *
     * @return 运营商数字代码
     * 46001 46006 46009 联通
     * 46000 46002 46004 46007 移动
     * 46003 46005 46011 电信
     * 其他未知
     */
    public static String getNetworkOperator(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getNetworkOperator();
    }


    /**
     * 获取注册的运营商名称,如果没有SIM卡返回空字符串
     *
     * @return 中国移动 中国联通 中国电信...
     */
    public static String getNetworkOperatorName(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getNetworkOperatorName();
    }

    /**
     * 返回与SIM卡提供商的国家/地区代码等效的ISO-3166-1 alpha-2国家/地区代码。没有SIM卡返回空字符串
     *
     * @return cn ...
     */
    public static String getSimCountryIso(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getSimCountryIso();
    }

    /**
     * 返回SIM卡提供商的MCC + MNC（移动国家/地区代码+移动网络代码）。5或6个十进制数字
     *
     * @return 46000 46002 ...
     */
    public static String getSimOperator(Context context) {
        if (!hasSim(context)) {
            return null;
        }
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getSimOperator();
    }

    /**
     * 返回服务提供商名称（SPN）
     *
     * @return CMCC ...
     * CMCC 中国移动
     * CUCC 中国联通
     * CTCC 中国电信
     * 其他未知
     */
    public static String getSimOperatorName(Context context) {
        if (!hasSim(context)) {
            return null;
        }
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getSimOperatorName();
    }
}
