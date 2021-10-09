package com.lib.utils.device;

import android.content.Context;

/**
 * @author :huangguofeng
 * date    :2021/8/3
 * package :com.lib.utils.device
 * desc    :屏幕尺寸单位转换
 */
public class ScreenUtils {
    /**
     * 根据手机的分辨率从PX(像素)的单位转成dip
     *
     * @param context context
     * @param pxValue 像素值
     */
    public static int pxToDip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /*根据手机的分辨率从dip的单位转化为px(像素)*/

    /**
     * 根据手机的分辨率从dip的单位转化为px
     *
     * @param context context
     * @param dpValue dp值
     */
    public static int dipToPx(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
