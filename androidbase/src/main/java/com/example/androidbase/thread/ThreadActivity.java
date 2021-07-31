package com.example.androidbase.thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidbase.R;
import com.lib.utils.Logger;

/**
 * @author huangguofeng
 */
public class ThreadActivity extends AppCompatActivity {
    private Handler handler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            Logger.logDebug(msg.what + "");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        findViewById(R.id.msg1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });

        findViewById(R.id.msg2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDelay();
            }
        });

    }

    private void sendDelay() {
        Logger.logDebug(Looper.myLooper() + "");
        Logger.logDebug(Looper.getMainLooper() + "");
        Message message = Message.obtain();
        message.what = 1;
        message.obj = "sendDelay";
        handler.sendMessageDelayed(message, 3000);
    }

    private void send() {
        Logger.logDebug(Looper.myLooper() + "");
        Logger.logDebug(Looper.getMainLooper() + "");
        Message message = Message.obtain();
        message.what = 0;
        message.obj = "send";
        handler.sendMessage(message);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 移除回调和消息 避免内存泄露
        handler.removeCallbacksAndMessages(null);
    }
}