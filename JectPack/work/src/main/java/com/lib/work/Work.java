package com.lib.work;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author :huangguofeng
 * date    :2021/1/17
 * package :com.lib.work
 * desc    :Work功能入口
 */
public class Work {
    private static final String TAG = "[Work]: ";
    private static Work work;

    private Work() {

    }

    public static Work get() {
        if (work == null) {
            synchronized (Work.class) {
                if (work == null) {
                    work = new Work();
                }
            }
        }
        return work;
    }

    /**
     * 创建一次工作，无需任何配置
     */
    public OneTimeWorkRequest createOneTimeWork(Class<? extends BaseWorker> workerClass) {
        return OneTimeWorkRequest.from(workerClass);
    }

    /**
     * 创建一次工作，需一些配置
     * setInitialDelay:工作入队后，延迟多少时间才开始执行
     * setBackoffCriteria:工作返回重试的结果时，工作重试策略，最低10秒。如果工作Result.retry()在随后的尝试之后继续返回（后续延迟允许误差几秒钟）
     * ******************BackoffPolicy.LINEAR：则将在10秒后再次尝试使用进行第一次运行结束，然后是20、30、40，依此类推
     * ******************BackoffPolicy.LINEAR：重试持续时间序列将更接近20、40、80，依此类推。
     * addTag:给工作添加标记，方便后续找到查询该工作状态，以及取消工作
     * setInputData:设置工作需要的键值对对象data，Data使用类似JsonObject bundle的用法
     *
     * @param workerClass 继承BaseWorker的类
     * @param data        初始化的数据
     * @param tag         工作的标记
     */
    public OneTimeWorkRequest createOneTimeWork(Class<? extends BaseWorker> workerClass, Data data, String tag) {
        return new OneTimeWorkRequest.Builder(workerClass).addTag(tag).setInputData(data).build();
    }

    /**
     * 创建一次工作，需一些配置
     *
     * @param workerClass 继承BaseWorker的类
     * @param data        初始化的数据
     * @param tag         工作的标记
     * @param constraints 约束条件
     */
    public OneTimeWorkRequest createOneTimeWork(Class<? extends BaseWorker> workerClass, Data data, String tag, Constraints constraints) {
        return new OneTimeWorkRequest.Builder(workerClass).addTag(tag).setInputData(data).setConstraints(constraints).build();
    }

    /**
     * 创建周期性工作
     *
     * @param workerClass 继承BaseWorker的类
     * @param data        初始化的数据
     * @param tag         工作的标记
     * @param time        执行周期时间数字
     * @param timeUnit    执行周期时间单位
     */
    public PeriodicWorkRequest createPeriodicWork(Class<? extends BaseWorker> workerClass, Data data, String tag, long time, TimeUnit timeUnit) {
        return new PeriodicWorkRequest.Builder(workerClass, time, timeUnit).addTag(tag).setInputData(data).build();

    }

    /**
     * 创建周期性工作
     *
     * @param workerClass 继承BaseWorker的类
     * @param data        初始化的数据
     * @param tag         工作的标记
     * @param time        执行周期时间数字
     * @param timeUnit    执行周期时间单位
     * @param constraints 约束条件
     */
    public PeriodicWorkRequest createPeriodicWork(Class<? extends BaseWorker> workerClass, Data data, String tag, long time, TimeUnit timeUnit, Constraints constraints) {
        return new PeriodicWorkRequest.Builder(workerClass, time, timeUnit).addTag(tag).setInputData(data).build();

    }

    /**
     * 创建约束条件
     * setRequiresCharging：是否要求充电状态 true or false
     * setRequiredNetworkType：要求的网络状况
     * setRequiresDeviceIdle：是否要求设备空闲
     * setRequiresBatteryNotLow：是否要求电量高
     * setRequiresStorageNotLow：是否要求内存大
     *
     * @param type     网络状况
     * @param charging 充电状态
     * @param device   设备空闲
     * @param battery  电池电量高
     * @param store    设备内存大
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    public Constraints createConstraints(NetworkType type, boolean charging, boolean device, boolean battery, boolean store) {
        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(type)
                .setRequiresCharging(charging)
                .setRequiresDeviceIdle(device)
                .setRequiresBatteryNotLow(battery)
                .setRequiresStorageNotLow(store)
                .build();
        return constraints;
    }

    /**
     * 把工作加入队列
     *
     * @param context context
     * @param request 请求
     */
    public void doWork(Context context, WorkRequest request) {
        WorkManager.getInstance(context).enqueue(request);
    }

    /**
     * 把一次性工作加入队列
     * ExistingWorkPolicy.KEEP:工作重复添加时的处理策略 保持原有
     * ExistingWorkPolicy.REPLACE:工作重复添加时的处理策略 替换
     * ExistingWorkPolicy.APPEND:工作重复添加时的处理策略 拼接
     *
     * @param context  context
     * @param request  请求
     * @param workName 定期事件名
     * @param type     重复策略
     */
    public void doOneTimeWork(Context context, OneTimeWorkRequest request, String workName, ExistingWorkPolicy type) {
        WorkManager.getInstance(context).enqueueUniqueWork(workName, type, request);
    }

    /**
     * 把周期性工作加入队列
     * ExistingPeriodicWorkPolicy.KEEP:工作重复添加时的处理策略 保持原有
     * ExistingPeriodicWorkPolicy.REPLACE:工作重复添加时的处理策略 替换
     *
     * @param context  context
     * @param request  请求
     * @param workName 定期事件名
     * @param type     重复策略
     */
    public void doPeriodicWork(Context context, PeriodicWorkRequest request, String workName, ExistingPeriodicWorkPolicy type) {
        WorkManager.getInstance(context).enqueueUniquePeriodicWork(workName, type, request);
    }

    /**
     * 根据id查询工作信息
     *
     * @param context context
     * @param request 请求
     */
    public ListenableFuture<WorkInfo> getWorkInfoById(Context context, WorkRequest request) {
        return WorkManager.getInstance(context).getWorkInfoById(request.getId());
    }

    /**
     * 根据tag查询工作信息
     *
     * @param context context
     * @param tag     工作的标记
     */
    public ListenableFuture<List<WorkInfo>> getWorkInfoByTag(Context context, String tag) {
        return WorkManager.getInstance(context).getWorkInfosByTag(tag);
    }

    /**
     * 根据id取消工作
     *
     * @param context context
     * @param request 请求
     */
    public void cancelWorkInfoById(Context context, WorkRequest request) {
        WorkManager.getInstance(context).cancelWorkById(request.getId());
    }

    /**
     * 根据tag取消工作
     *
     * @param context context
     * @param tag     工作的标记
     */
    public void cancelWorkInfoByTag(Context context, String tag) {
        WorkManager.getInstance(context).cancelAllWorkByTag(tag);
    }

    /**
     * 获取实时的工作信息
     *
     * @param context  context
     * @param owner    生命周期拥有者
     * @param request  工作
     * @param callback 接收工作信息的回调
     */
    public void getWorkInfoByIdLiveData(Context context, LifecycleOwner owner, WorkRequest request, WorkCallback callback) {
        WorkManager.getInstance(context).getWorkInfoByIdLiveData(request.getId()).observe(owner, new Observer<WorkInfo>() {
            @Override
            public void onChanged(WorkInfo workInfo) {
                callback.change(workInfo);
            }
        });
    }

    /**
     * 工作信息观察者回调
     */
    public interface WorkCallback {
        /**
         * 工作信息更改
         *
         * @param workInfo 工作信息
         */
        void change(WorkInfo workInfo);
    }

    //    /**
//     * 根据复杂工作组名查询工作信息
//     */
//    public ListenableFuture<List<WorkInfo>> getWorkInfoForUniqueWork(Context context, String workName) {
//        return WorkManager.getInstance(context).getWorkInfosForUniqueWork(workName);
//    }
//
//    /**
//     * 查询复杂的工作信息
//     */
//    public ListenableFuture<List<WorkInfo>> getWorkInfo(Context context, String tag) {
//        WorkQuery workQuery = WorkQuery.Builder
//                .fromTags(Arrays.asList("syncTag"))
//                .addStates(Arrays.asList(WorkInfo.State.FAILED, WorkInfo.State.CANCELLED))
//                .addUniqueWorkNames(Arrays.asList("preProcess", "sync"))
//                .build();
//
//        return WorkManager.getInstance(context).getWorkInfos(workQuery);
//    }
//
//    /**
//     * 根据复杂工作组名取消工作组
//     */
//    public void cancelWorkInfoForUniqueWork(Context context, String workName) {
//        WorkManager.getInstance(context).cancelUniqueWork(workName);
//    }

}
