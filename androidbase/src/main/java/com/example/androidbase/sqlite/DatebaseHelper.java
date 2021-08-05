package com.example.androidbase.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

/**
 * @author :huangguofeng
 * date    :2021/8/5
 * package :com.example.androidbase.sqlite
 * desc    :
 */
public abstract class DatebaseHelper {
    protected SQLiteDatabase db;

    protected SQLiteDatabase getDateBase() {
        if (db != null) {
            return db;
        }
        db = new DBHelper().getInstance();
        return db;
    }

    /**
     * 关闭数据库
     */
    protected void closeDB() {
        SQLiteDatabase db = getDateBase();
        if (db != null) {
            db.close();
        }
    }

    /**
     * 判断表存在
     */
    protected boolean isTableExist(String tableName) {
        Cursor cursor = getDateBase().rawQuery("select name from sqlite_master where type='table';", null);
        while (cursor.moveToNext()) {
            if (cursor.getString(0).equals(tableName)) {
                cursor.close();
                return true;
            }
        }
        cursor.close();
        return false;
    }

    /**
     * 查询
     **/
    protected abstract List<?> checkAll();

    /**
     * 添加
     **/
    protected abstract <T> void insert(T t);

    /**
     * 删除
     **/
    protected abstract void delete(Object obj);

    /**
     * 更新
     **/
    protected abstract void update(Object obj);


}
