package com.example.androidbase.sqlite.ormlite;

import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidbase.R;
import com.lib.utils.Logger;

import java.util.ArrayList;

public class OrmliteActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    MyDataDao myDataDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        myDataDao = MyDataDao.getInstance(this);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean state = Looper.myLooper() == Looper.getMainLooper();
                Logger.logInfo("当前线程是主线程吗？ " + (state ? "是" : "否"));
                ArrayList<MyBean> list = myDataDao.queryAll();
                if (list.isEmpty()) {
                    Logger.logInfo("数据库无数据");
                    return;
                }
                for (int i = 0; i < list.size(); i++) {
                    Logger.logInfo(list.get(i).toString());
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //添加
                MyBean bean = new MyBean();
                bean.setName("huang");
                bean.setAuthor("huang");
                bean.setPages(100);
                bean.setPrice("20");

                MyBean bean2 = new MyBean();
                bean2.setName("zhai");
                bean2.setAuthor("zhai");
                bean2.setPages(80);
                bean2.setPrice("30");

                MyBean bean3 = new MyBean();
                bean3.setName("yuan");
                bean3.setAuthor("yuan");
                bean3.setPages(10);
                bean3.setPrice("50");

                myDataDao.insert(bean);
                myDataDao.insert(bean2);
                myDataDao.insert(bean3);
                Logger.logInfo("数据添加结束 ");
            }
        });
        button3.setText("更新某一数据");
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDataDao.update("huang", "300");
                Logger.logInfo("数据更新完成 ");
            }
        });
        button4.setText("更新某列数据");
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDataDao.update2("pages", "1000");
                Logger.logInfo("数据更新完成 ");
            }
        });

        button5.setText("更新某一数据");
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDataDao.update3("name", "yuan", "author", "bao");
                Logger.logInfo("数据更新完成 ");
            }
        });
        button6.setText("删除某一数据");
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDataDao.delete("huang");
                Logger.logInfo("数据删除结束 ");
            }
        });
        button7.setText("删除全部数据");
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDataDao.deleteAll();
                Logger.logInfo("数据全部删除 ");
            }
        });
        button8.setText("查询价格");
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.logInfo("数据删除完毕 " + myDataDao.queryPrice("yuan"));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}