package com.example.androidbase.sqlite.greendao;

import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidbase.App;
import com.example.androidbase.R;
import com.example.androidbase.sqlite.greendao.db.UserDao;
import com.lib.utils.Logger;

import java.util.List;

public class GreenDaoActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_dao);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);

        App app = (App) getApplication();
        userDao = app.getDaoSession().getUserDao();

        User user = new User();
        user.setId(1);
        user.setName("小明");
        user.setAge(16);
        userDao.insert(user);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean state = Looper.myLooper() == Looper.getMainLooper();
                Logger.logInfo("当前线程是主线程吗？ " + (state ? "是" : "否"));
                List<User> list = userDao.loadAll();
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
                User user = new User();
                user.setId(2);
                user.setName("小黄");
                user.setAge(26);
                userDao.insertOrReplace(user);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setId(1);
                user.setName("小明");
                user.setAge(17);
                userDao.update(user);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userDao.deleteByKey(1L);
            }
        });

        /**
         * userDao.queryRaw("where AGE>?","10");//查询年龄大于10的用户
         * userDao.queryBuilder().where(UserDao.Properties.Age.gt(10)).build().list();//查询年龄大于10的用户
         * userDao.loadByRowId(1);//根据ID查询
         * userDao.loadAll();// 查询所有记录
         * userDao.update(user);更新数据
         * userDao.deleteByKey(1L);删除数据
         * userDao.delete(user);删除数据
         * userDao.insert(user);新增数据
         * userDao.insertOrReplace(user);新增或者替换
         * 更多使用
         * https://blog.csdn.net/speedystone/article/details/74193053
         */
    }
}