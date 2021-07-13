package com.lib.work;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/**
 * @author :huangguofeng
 * date    :2021/1/17
 * package :com.lib.work.base
 * desc    :基础work
 */
public class BaseWorker extends Worker {
    private static final String PROGRESS = "PROGRESS";

    public BaseWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        setProgressAsync(new Data.Builder().putInt(PROGRESS, 0).build());
    }

    @NonNull
    @Override
    public Result doWork() {
        return Result.success();
    }

    @Override
    public void onStopped() {
        super.onStopped();
    }

    public void complete() {
        setProgressAsync(new Data.Builder().putInt(PROGRESS, 100).build());
    }
}
