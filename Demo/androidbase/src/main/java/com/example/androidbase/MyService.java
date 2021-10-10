package com.example.androidbase;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.lib.utils.Logger;

public class MyService extends Service {
    public MyService() {
        Logger.logInfo("MyService : " + this.getClass().getSimpleName());
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Logger.logInfo("onBind : " + this.getClass().getSimpleName());
        return new MyBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Logger.logInfo("onUnbind : " + this.getClass().getSimpleName());
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.logInfo("onCreate : " + this.getClass().getSimpleName());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.logInfo("onDestroy : " + this.getClass().getSimpleName());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Logger.logInfo("onStartCommand : " + this.getClass().getSimpleName());
        return super.onStartCommand(intent, flags, startId);
    }

    public class MyBinder extends Binder {
        private MyBinder() {
            Logger.logInfo("MyBinder : " + this.getClass().getSimpleName());
        }

        public void print() {
            Logger.logInfo("print : " + this.getClass().getSimpleName());
        }

        public MyService getMyService() {
            return MyService.this;
        }
    }

    public void print() {
        Logger.logInfo("print : " + this.getClass().getSimpleName());
    }

}