package com.example.androidbase.thread;

import android.os.AsyncTask;

/**
 * @author :huangguofeng
 * date    :2021/8/6
 * package :com.example.androidbase.thread
 * desc    :AsyncTask内部也是通过线程池+Handler的方式实现
 */
public class MyAsyncTask extends AsyncTask<String, Process, String> {
    //此方法在子线程运行，用来处理后台任务，像网络请求，耗时处理等操作
    @Override
    protected String doInBackground(String... strings) {
        return null;
    }

    //此方法在在主线程运行，用于后台任务进行前做一些准备工作
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    //此方法在在主线程运行，后台任务处理完毕调用，并返回后台任务的结果
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    //此方法在在主线程运，在doInBackground通过publishProgress来调用，用来更新进度
    @Override
    protected void onProgressUpdate(Process... values) {
        super.onProgressUpdate(values);
    }

    public void start(String... p) {
        execute(p);
    }
}
