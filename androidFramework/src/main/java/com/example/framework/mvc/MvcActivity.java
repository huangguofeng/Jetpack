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
import com.example.framework.news.News;
import com.lib.http.HttpCallback;
import com.lib.utils.Logger;

import java.util.ArrayList;
import java.util.List;

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
                newsModel.load(httpCallback);
            }
        });
    }

    private HttpCallback httpCallback = new HttpCallback() {
        @Override
        public void success(int code, Object o) {
            News news = (News) o;
            List<News.ResultBean.DataBean> dataBeans = new ArrayList<>();
            if (news.getResult() != null && news.getResult().getData() != null) {
                Logger.logDebug("load " + news.getResult().getData().size());
                for (int i = 0; i < dataBeans.size(); i++) {
                    Logger.logDebug("load " + dataBeans.toString());
                }
                dataBeans = news.getResult().getData();
                Message message = Message.obtain();
                message.obj = dataBeans.get(0).title;
                handler.sendMessage(message);
            } else {
                Logger.logError("网络数据错误");
            }
        }

        @Override
        public void fail(int errorCode, String errorMsg) {

        }
    };

}