package com.example.androidbase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.lib.utils.Logger;

/**
 * @author huangguofeng
 */
public class MainActivity extends AppCompatActivity implements Fragment1.FragmentCallback {
    Button button;
    Fragment1 fg1;
    FragmentManager fragmentManager;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.logInfo("onCreate : " + this.getClass().getSimpleName());
        
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        button = findViewById(R.id.bt);
        transaction = fragmentManager.beginTransaction();
        fg1 = new Fragment1();
        fg1.setFragmentCallback(this);
        transaction.add(fg1, "fg1");
        button.setText(this.getClass().getSimpleName());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                receive();
            }
        });

        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                transaction.hide(fg1);
                transaction.commit();
                return true;
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Logger.logInfo("onStart : " + this.getClass().getSimpleName());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Logger.logInfo("onRestart : " + this.getClass().getSimpleName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.logInfo("onResume : " + this.getClass().getSimpleName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.logInfo("onPause : " + this.getClass().getSimpleName());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.logInfo("onStop : " + this.getClass().getSimpleName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.logInfo("onDestroy : " + this.getClass().getSimpleName());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Logger.logInfo("onNewIntent : " + this.getClass().getSimpleName());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Logger.logInfo("onSaveInstanceState : " + this.getClass().getSimpleName());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Logger.logInfo("onBackPressed : " + this.getClass().getSimpleName());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Logger.logInfo("onActivityResult : " + this.getClass().getSimpleName() + "  " + requestCode + " " + resultCode);
    }

    @Override
    public void send() {
        Logger.logInfo("send : " + this.getClass().getSimpleName());
    }

    public void receive() {
        Logger.logInfo("receive : " + this.getClass().getSimpleName());
        fg1.send1();
    }
}