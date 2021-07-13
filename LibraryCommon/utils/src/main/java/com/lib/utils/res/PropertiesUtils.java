package com.lib.utils.res;

import android.content.Context;
import android.text.TextUtils;

import com.lib.utils.Logger;
import com.lib.utils.app.AppUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

/**
 * @author :huangguofeng
 * date    :2021/1/11
 * package :com.lib.utils.res
 * desc    :raw下的properties配置文件读取解析
 */
public class PropertiesUtils {
    private static final String TAG = "[PropertiesUtils]: ";
    private static PropertiesUtils propertiesUtils;
    private static final String RAW = "raw";
    private static final String RAW_TAG = "raw-";
    private static final String ASSETS_TAG = "assets-";
    private static final String PROPERTIES_TYPE = ".properties";
    private HashMap<String, Properties> list = new HashMap<>();

    public static synchronized PropertiesUtils get() {
        if (propertiesUtils == null) {
            synchronized (PropertiesUtils.class) {
                if (propertiesUtils == null) {
                    propertiesUtils = new PropertiesUtils();
                }
            }
        }
        return propertiesUtils;
    }

    /**
     * 从raw目录下读取配置文件的key对应的value值
     *
     * @param context Context
     * @param name    properties配置文件名，不需要后缀
     * @param key     properties配置文件中属性key
     * @return Object 自行转换为需要的类型
     */
    public Object getRawValue(Context context, String name, String key) {
        if (context == null || TextUtils.isEmpty(name) || TextUtils.isEmpty(key)) {
            Logger.logError(TAG + "参数不允许为null对象或者空值，getRawValue即将返回null");
            return null;
        }

        if (list.isEmpty() || list.get(RAW_TAG + name) == null) {
            Properties p = null;
            int resId = context.getResources().getIdentifier(name, RAW, AppUtils.getPackageName(context));
            if (resId > 0) {
                p = getPropertiesFromRaw(context, resId);
                if (p != null) {
                    list.put(RAW_TAG + name, p);
                }
            } else {
                Logger.logError(TAG + "raw目录下找不到文件: " + name);
            }
        }
        Object parameter = list.get(RAW_TAG + name).get(key);
        if (parameter == null) {
            Logger.logError(TAG + name + PROPERTIES_TYPE + "文件内找不到属性 : " + key);
            return null;
        }
        return parameter;
    }

    /**
     * 往raw配置文件中加入或覆盖某字段
     *
     * @param key   要增加或者修改的key
     * @param value 要增加或者修改的key的值
     * @return 成功与否
     */
    public boolean putRawValue(Context context, String name, String key, Object value) {
        if (context == null || TextUtils.isEmpty(name) || TextUtils.isEmpty(key) || value == null) {
            Logger.logError(TAG + "参数不允许为null对象或者空值，getRawValue即将返回null");
            return false;
        }

        if (list.isEmpty() || list.get(RAW_TAG + name) == null) {
            Properties p = null;
            int resId = context.getResources().getIdentifier(name, RAW, AppUtils.getPackageName(context));
            if (resId > 0) {
                p = getPropertiesFromRaw(context, resId);
                if (p != null) {
                    list.put(RAW_TAG + name, p);
                } else {
                    return false;
                }
            } else {
                Logger.logError(TAG + "raw目录下找不到文件: " + name);
                return false;
            }
        }
        list.get(RAW_TAG + name).put(key, value);
        return true;
    }

    /**
     * 从assets目录内的配置文件中读取某字段值
     *
     * @param context Context
     * @param name    properties配置文件名，不需要后缀
     * @param key     properties配置文件中属性key
     * @return Object 自行转换为需要的类型
     */
    public Object getAssetsValue(Context context, String name, String key) {
        if (context == null || TextUtils.isEmpty(name) || TextUtils.isEmpty(key)) {
            Logger.logError(TAG + "参数不允许为null对象或者空值，getRawValue即将返回null");
            return null;
        }

        if (list.isEmpty() || list.get(ASSETS_TAG + name) == null) {
            Properties p = getPropertiesFromAssets(context, name + PROPERTIES_TYPE);
            if (p != null) {
                list.put(ASSETS_TAG + name, p);
            } else {
                Logger.logError(TAG + "assets目录下找不到文件: " + name);
            }
        }
        Object parameter = list.get(ASSETS_TAG + name).get(key);
        if (parameter == null) {
            Logger.logError(TAG + name + PROPERTIES_TYPE + "文件内找不到属性 : " + key);
            return null;
        }
        return parameter;
    }

    /**
     * 往配置文件中加入或覆盖某字段
     *
     * @param key   字段名
     * @param value 值
     * @return 成功与否
     */
    public boolean putAssetsValue(Context context, String name, String key, Object value) {
        if (context == null || TextUtils.isEmpty(name) || TextUtils.isEmpty(key) || value == null) {
            Logger.logError(TAG + "参数不允许为null对象或者空值，getRawValue即将返回null");
            return false;
        }

        if (list.isEmpty() || list.get(ASSETS_TAG + name) == null) {
            Properties p = getPropertiesFromAssets(context, name + PROPERTIES_TYPE);
            if (p != null) {
                list.put(ASSETS_TAG + name, p);
            } else {
                Logger.logError(TAG + "assets目录下找不到文件: " + name);
            }
        }
        list.get(ASSETS_TAG + name).put(key, value);
        return true;
    }

    /**
     * 从raw文件夹中获取某个配置文件
     *
     * @param context  Context
     * @param rawResId 资源id，必须在raw文件夹
     * @return 配置文件的实体
     */
    private Properties getPropertiesFromRaw(Context context, int rawResId) {
        Properties properties = null;
        InputStream inputStream = null;
        try {
            properties = new Properties();
            inputStream = context.getResources().openRawResource(rawResId);
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            Logger.logError(TAG + "从raw目录下读取配置文件失败: " + e.getMessage(), e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }

    /**
     * 从assets文件夹中获取某个配置文件
     *
     * @param context  Context
     * @param fileName 文件名称
     * @return Properties
     */
    private static Properties getPropertiesFromAssets(Context context, String fileName) {
        Properties properties = null;
        InputStream inputStream = null;
        try {
            properties = new Properties();
            inputStream = context.getAssets().open(fileName);

            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            Logger.logError(TAG + "从assets目录下读取配置文件失败: " + e.getMessage(), e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }
}
