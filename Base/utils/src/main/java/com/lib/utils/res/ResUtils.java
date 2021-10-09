package com.lib.utils.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;

/**
 * @author :huangguofeng
 * date    :2021/1/11
 * package :com.lib.utils.res
 * desc    :全局资源索引，避免R引用导致找不到被固定的资源
 */
public class ResUtils {
    private static String packageName = null;
    private static Resources resources = null;

    /**
     * 缓存包名
     */
    private static String packageName(Context context) {
        if (packageName == null) {
            packageName = context.getPackageName();
        }
        return packageName;
    }

    /**
     * 缓存resource对象
     */
    private static int identifier(Context context, String name, String type) {
        if (resources == null) {
            resources = context.getResources();
        }
        return resources.getIdentifier(name, type, packageName(context));
    }

    /**
     * 获取String资源id
     */
    public static int getString(Context context, String name) {
        return identifier(context, name, "string");
    }

    /**
     * 获取Rwa资源id
     */
    public static int getRaw(Context context, String name) {
        return identifier(context, name, "raw");
    }

    /**
     * 获取Drawable资源id
     */
    public static int getDrawable(Context context, String name) {
        return identifier(context, name, "drawable");
    }

    /**
     * 获取Mipmap资源id
     */
    public static int getMipmap(Context context, String name) {
        return identifier(context, name, "mipmap");
    }

    /**
     * 获取id资源id
     */
    public static int getId(Context context, String name) {
        return identifier(context, name, "id");
    }

    /**
     * 获取Layout资源id
     */
    public static int getLayout(Context context, String name) {
        return identifier(context, name, "layout");
    }

    /**
     * 获取Menu资源id
     */
    public static int getMenu(Context context, String name) {
        return identifier(context, name, "menu");
    }

    /**
     * 获取Style资源id
     */
    public static int getStyle(Context context, String name) {
        return identifier(context, name, "style");
    }

    /**
     * 获取Dimen资源id
     */
    public static int getDimen(Context context, String name) {
        return identifier(context, name, "dimen");
    }

    /**
     * 获取Color资源id
     */
    public static int getColor(Context context, String name) {
        return identifier(context, name, "color");
    }

    /**
     * 获取Anim资源id
     */
    public static int getAnim(Context context, String name) {
        return identifier(context, name, "anim");
    }

    /**
     * 获取Attr资源id
     */
    public static int getAttr(Context context, String name) {
        return identifier(context, name, "attr");
    }

    /**
     * 获取color资源对象
     */
    public static int getColorResource(Context context, String name) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return context.getResources().getColor(getColor(context, name), null);
        } else {
            return context.getResources().getColor(getColor(context, name));
        }
    }

    /**
     * 获取Drawable资源对象
     */
    @SuppressLint("UseCompatLoadingForDrawables")
    public static Drawable getDrawableResource(Context context, String name) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return context.getResources().getDrawable(getDrawable(context, name), null);
        } else {
            return context.getResources().getDrawable(getDrawable(context, name));
        }
    }

    /**
     * 获取String资源对象
     */
    public static String getStringResource(Context context, String name) {
        return context.getResources().getString(getString(context, name));
    }
}
