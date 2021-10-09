package com.lib.utils.file;

import android.content.Context;
import android.os.Parcelable;
import android.text.TextUtils;

import com.tencent.mmkv.MMKV;

import java.util.Collections;
import java.util.Set;

/**
 * @author :huangguofeng
 * date    :2021/2/5
 * package :com.lib.sp
 * desc    :轻量高效的kv储存读取工具
 */
public class MmKvUtil {
    private static MMKV kv;
    private static final String TAG = "[MmKvUtil]: ";
    private static String root;

    public static void init(Context context) {
        if (kv == null) {
            synchronized (MmKvUtil.class) {
                if (kv == null) {
                    root = MMKV.initialize(context);
                    kv = MMKV.defaultMMKV();
                }
            }
        }
    }

    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     *
     * @param key   键值对之键
     * @param value 键值对之值
     */
    public static void put(String key, Object value) {
        if (checkKey(key) || checkValue(value)) {
            return;
        }
        if (value instanceof String) {
            kv.encode(key, (String) value);
        } else if (value instanceof Integer) {
            kv.encode(key, (Integer) value);
        } else if (value instanceof Boolean) {
            kv.encode(key, (Boolean) value);
        } else if (value instanceof Float) {
            kv.encode(key, (Float) value);
        } else if (value instanceof Long) {
            kv.encode(key, (Long) value);
        } else if (value instanceof Double) {
            kv.encode(key, (Double) value);
        } else if (value instanceof byte[]) {
            kv.encode(key, (byte[]) value);
        } else {
            kv.encode(key, value.toString());
        }
    }

    public static void putSet(String key, Set<String> value) {
        if (checkKey(key) || checkValue(value)) {
            return;
        }
        kv.encode(key, value);
    }

    public static void putParcelable(String key, Parcelable value) {
        if (checkKey(key) || checkValue(value)) {
            return;
        }
        kv.encode(key, value);
    }


    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     */
    public static Integer getInt(String key) {
        if (checkKey(key)) {
            return 0;
        }
        return kv.decodeInt(key, 0);
    }

    public static Double getDouble(String key) {
        if (checkKey(key)) {
            return 0.00;
        }
        return kv.decodeDouble(key, 0.00);
    }

    public static Long getLong(String key) {
        if (checkKey(key)) {
            return 0L;
        }
        return kv.decodeLong(key, 0L);
    }

    public static Boolean getBoolean(String key) {
        if (checkKey(key)) {
            return false;
        }
        return kv.decodeBool(key, false);
    }

    public static Float getFloat(String key) {
        if (checkKey(key)) {
            return 0F;
        }
        return kv.decodeFloat(key, 0F);
    }

    public static byte[] getBytes(String key) {
        if (checkKey(key)) {
            return null;
        }
        return kv.decodeBytes(key);
    }

    public static String getString(String key) {
        if (checkKey(key)) {
            return "";
        }
        return kv.decodeString(key, "");
    }

    public static Set<String> getStringSet(String key) {
        if (checkKey(key)) {
            return null;
        }
        return kv.decodeStringSet(key, Collections.<String>emptySet());
    }

    public static Parcelable getParcelable(String key) {
        if (checkKey(key)) {
            return null;
        }
        return kv.decodeParcelable(key, null);
    }

    /**
     * 移除某个key对
     *
     * @param key key
     */
    public static void removeKey(String key) {
        if (checkKey(key)) {
            return;
        }
        if (kv.contains(key)) {
            kv.removeValueForKey(key);
        }
    }

    /**
     * 清除所有key
     */
    public static void clearAll() {
        kv.clearAll();
    }

    /**
     * 检查参数key是否合规
     */
    private static boolean checkKey(String key) {
        if (TextUtils.isEmpty(key)) {
            return true;
        }
        return false;
    }

    /**
     * 检查参数value是否合规
     */
    private static boolean checkValue(Object value) {
        if (value == null) {
            return true;
        }
        return false;
    }
}
