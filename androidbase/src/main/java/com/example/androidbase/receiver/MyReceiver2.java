package com.example.androidbase.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.lib.utils.Logger;
import com.lib.utils.device.NetworkUtils;

public class MyReceiver2 extends BroadcastReceiver {
    private final static String TGA = "MyReceiver2: ";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if (intent != null) {
            Logger.logDebug(TGA + intent.getAction());
            Logger.logDebug(TGA + intent.getIntExtra("test", -1));
        }

        Logger.logDebug(TGA + NetworkUtils.isWifiState() + "");
        Logger.logDebug(TGA + NetworkUtils.isMobileNetWorkState() + "");
        Logger.logDebug(TGA + NetworkUtils.isNetAvailable() + "");
    }
}