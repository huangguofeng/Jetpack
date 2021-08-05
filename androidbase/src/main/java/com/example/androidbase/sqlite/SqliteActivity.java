package com.example.androidbase.sqlite;

import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidbase.R;
import com.lib.utils.Logger;

import java.util.List;

public class SqliteActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    private Button button11;
    private Button button12;

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
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        button11 = (Button) findViewById(R.id.button11);
        button12 = (Button) findViewById(R.id.button12);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean state = Looper.myLooper() == Looper.getMainLooper();
                Logger.logInfo("当前线程是主线程吗？ " + (state ? "是" : "否"));
                List<Person> list = (List<Person>) PersonDbHelper.getInstance().checkAll();
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
                Person person = new Person();
                person.setName("huang");
                person.setAge(26);
                Person person1 = new Person();
                person1.setName("zhai");
                person1.setAge(27);
                PersonDbHelper.getInstance().insert(person);
                PersonDbHelper.getInstance().insert(person1);
                Logger.logInfo("数据添加结束 ");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person();
                person.setName("huang");
                person.setAge(36);
                Person person1 = new Person();
                person1.setName("zhai");
                person1.setAge(37);
                PersonDbHelper.getInstance().update(person);
                PersonDbHelper.getInstance().update(person1);
                Logger.logInfo("数据更新完成 ");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person();
                person.setName("huang");
                Person person1 = new Person();
                person1.setName("zhai");
                PersonDbHelper.getInstance().delete(person);
                PersonDbHelper.getInstance().delete(person1);
                Logger.logInfo("数据删除完毕 ");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean state = Looper.myLooper() == Looper.getMainLooper();
                Logger.logInfo("当前线程是主线程吗？ " + (state ? "是" : "否"));
                List<Person> list = (List<Person>) PersonDbHelper.getInstance().checkAll();
                if (list.isEmpty()) {
                    Logger.logInfo("数据库无数据");
                    return;
                }
                for (int i = 0; i < list.size(); i++) {
                    Logger.logInfo(list.get(i).toString());
                }
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean state = Looper.myLooper() == Looper.getMainLooper();
                Logger.logInfo("当前线程是主线程吗？ " + (state ? "是" : "否"));
                Person person = new Person();
                person.setName("huang");
                person.setAge(26);
                Person person1 = new Person();
                person1.setName("zhai");
                person1.setAge(27);
                Person2DbHelper.getInstance().insert(person);
                Person2DbHelper.getInstance().insert(person1);
                Logger.logInfo("数据添加结束 ");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean state = Looper.myLooper() == Looper.getMainLooper();
                Logger.logInfo("当前线程是主线程吗？ " + (state ? "是" : "否"));
                Person person = new Person();
                person.setName("huang");
                person.setAge(36);
                Person person1 = new Person();
                person1.setName("zhai");
                person1.setAge(37);
                Person2DbHelper.getInstance().update(person);
                Person2DbHelper.getInstance().update(person1);
                Logger.logInfo("数据更新完成 ");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean state = Looper.myLooper() == Looper.getMainLooper();
                Logger.logInfo("当前线程是主线程吗？ " + (state ? "是" : "否"));
                Person person = new Person();
                person.setName("huang");
                Person person1 = new Person();
                person1.setName("zhai");
                Person2DbHelper.getInstance().delete(person);
                Person2DbHelper.getInstance().delete(person1);
                Logger.logInfo("数据删除完毕 ");
            }
        });


        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean state = Looper.myLooper() == Looper.getMainLooper();
                Logger.logInfo("当前线程是主线程吗？ " + (state ? "是" : "否"));
                List<Person> list = PersonHelper.get().checkAll();
                if (list.isEmpty()) {
                    Logger.logInfo("数据库无数据");
                    return;
                }
                for (int i = 0; i < list.size(); i++) {
                    Logger.logInfo(list.get(i).toString());
                }
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean state = Looper.myLooper() == Looper.getMainLooper();
                Logger.logInfo("当前线程是主线程吗？ " + (state ? "是" : "否"));
                Person person = new Person();
                person.setName("huang");
                person.setAge(26);
                Person person1 = new Person();
                person1.setName("zhai");
                person1.setAge(27);
                PersonHelper.get().insert(person);
                PersonHelper.get().insert(person1);
                Logger.logInfo("数据添加结束 ");
            }
        });

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean state = Looper.myLooper() == Looper.getMainLooper();
                Logger.logInfo("当前线程是主线程吗？ " + (state ? "是" : "否"));
                Person person = new Person();
                person.setName("huang");
                person.setAge(36);
                Person person1 = new Person();
                person1.setName("zhai");
                person1.setAge(37);
                PersonHelper.get().update(person);
                PersonHelper.get().update(person1);
                Logger.logInfo("数据更新完成 ");
            }
        });

        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean state = Looper.myLooper() == Looper.getMainLooper();
                Logger.logInfo("当前线程是主线程吗？ " + (state ? "是" : "否"));
                Person person = new Person();
                person.setName("huang");
                Person person1 = new Person();
                person1.setName("zhai");
                PersonHelper.get().delete(person);
                PersonHelper.get().delete(person1);
                Logger.logInfo("数据删除完毕 ");
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PersonDbHelper.getInstance().closeDB();
        Person2DbHelper.getInstance().closeDB();
        PersonHelper.get().closeDB();
    }
}