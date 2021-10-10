package com.example.framework.mvc;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.framework.R;

/**
 * @author huangguofeng
 * Controller角色+View角色
 */
public class MvcActivity extends AppCompatActivity {
    private Button button;
    private TextView textview;
    private NewsModel newsModel = new NewsModel();
    private Handler handler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            textview.setText((CharSequence) msg.obj);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        button = (Button) findViewById(R.id.button);
        textview = (TextView) findViewById(R.id.textview);
        textview.setText("默认文本");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newsModel.load();
            }
        });
    }

}