package com.lib.utils.permission;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;

/**
 * @author :huangguofeng
 * date    :2021/1/11
 * package :com.lib.utils.permission
 * desc    :权限管理工具：只负责核心的查询 请求 判断，不负责外层的逻辑弹框UI部分
 */
public class PermissionUtils {

    /**
     * 请动态权限
     *
     * @param activity Activity
     */
    public static void requestPermissions(Activity activity, String[] permissions, int requestCode) {
        /*
         * 6.0以上才需要申请动态权限，6.0以下权限全部自动授权
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(activity, permissions, requestCode);
        }
    }

    /**
     * 是否应该展示弹框，说明为何需要该权限
     * 1：如果用户曾经拒绝过权限，或者在设置界面里关掉过权限，那么会返回true，此时可以弹出申请原因
     * 2：如果用户从来没有拒绝过权限，或者点了'不再提示'并拒绝，又或者系统本身不允许这种权限的出现。则会返回false，此时不可以弹出申请原因
     */
    public static boolean shouldShowRequestPermissionRationale(Activity activity, String permission) {
        return ActivityCompat.shouldShowRequestPermissionRationale(activity, permission);
    }

    /**
     * 判断应用是否禁用了自动重置权限开关
     *
     * @param ctx Context
     * @return true：禁用自动重置，授权的权限永久拥有，false：启用自动重置，长期不用权限会自动撤销
     */
    @RequiresApi(api = Build.VERSION_CODES.R)
    public static boolean isAutoRevokeWhitelisted(Context ctx) {
        PackageManager pm = ctx.getPackageManager();
        return pm.isAutoRevokeWhitelisted();
    }

    /**
     * 检查应用是否有某个权限
     *
     * @param ctx        Context
     * @param permission permission
     * @return 是否已获取此权限授权
     */
    public static boolean checkPermission(Context ctx, String permission) {
        return ActivityCompat.checkSelfPermission(ctx, permission) == PackageManager.PERMISSION_GRANTED;
    }
}
