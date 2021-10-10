package com.example.androidbase.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lib.utils.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :huangguofeng
 * date    :2021/8/5
 * package :com.example.androidbase.sqlite
 * desc    :
 */
public class PersonHelper implements DbInterface {

    protected SQLiteDatabase db;
    private static PersonHelper personHelper;

    private PersonHelper() {

    }

    public static PersonHelper get() {
        if (personHelper == null) {
            personHelper = new PersonHelper();
        }
        return personHelper;
    }

    protected SQLiteDatabase getDateBase() {
        if (db != null) {
            return db;
        }
        db = new DBHelper().getInstance();
        Logger.logInfo(db.getPath());
        Logger.logInfo(db.getMaximumSize() + "");
        return db;
    }

    /**
     * 关闭数据库
     */
    protected void closeDB() {
        if (db != null) {
            db.close();
            db = null;
        }
    }

    @Override
    public List<Person> checkAll() {
        List<Person> list = new ArrayList<>();
        Cursor cursor = getDateBase().query("person", new String[]{"name", "age"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Person person = new Person();
            person.setAge(cursor.getInt(cursor.getColumnIndex("age")));
            person.setName(cursor.getString(cursor.getColumnIndex("name")));
            list.add(person);
        }
        cursor.close();
        return list;
    }

    @Override
    public void insert(Person person) {
        ContentValues values = new ContentValues();
        values.put("name", person.getName());
        values.put("age", person.getAge());
        long count = getDateBase().insert("person", null, values);
        Logger.logInfo("insert result = " + count);
    }

    @Override
    public void delete(Person person) {
        ContentValues values = new ContentValues();
        values.put("name", person.getName());
        values.put("age", person.getAge());
        long count = getDateBase().delete("person", "name=?", new String[]{(String) values.get("name")});
        Logger.logInfo("insert result = " + count);
    }

    @Override
    public void update(Person person) {
        ContentValues values = new ContentValues();
        values.put("name", person.getName());
        values.put("age", person.getAge());
        long count = getDateBase().update("person", values, "name=?", new String[]{(String) values.get("name")});
        Logger.logInfo("update result = " + count);
    }
}
