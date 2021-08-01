package com.example.androidbase.receiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidbase.R;

public class ReceiverActivity extends AppCompatActivity {
    MyReceiver1 networkChangedReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        findViewById(R.id.send1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent("test");
                intent1.putExtra("test", 0);
                sendBroadcast(intent1);

                Intent intent = new Intent(Intent.ACTION_BATTERY_CHANGED);
                intent.putExtra("test", 0);
                sendBroadcast(intent);
            }
        });

        findViewById(R.id.send2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.action.test");
                intent.putExtra("test", 1);
                sendBroadcast(intent);
            }
        });

        networkChangedReceiver = new MyReceiver1();
        IntentFilter intentFilter = new IntentFilter("com.action.test");
        registerReceiver(networkChangedReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangedReceiver);
    }
}