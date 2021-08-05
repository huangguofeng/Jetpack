package com.example.androidbase.sqlite;

import android.content.ContentValues;
import android.database.Cursor;

import com.lib.utils.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :huangguofeng
 * date    :2021/8/5
 * package :com.example.androidbase.sqlite
 * desc    :
 */
public class Person2DbHelper extends DatebaseHelper {

    private static Person2DbHelper personDbHelper;

    private Person2DbHelper() {

    }

    public static Person2DbHelper getInstance() {
        if (personDbHelper == null) {
            return new Person2DbHelper();
        }
        return personDbHelper;
    }


    @Override
    protected List<?> checkAll() {
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
    protected <T> void insert(T t) {
        Person person = (Person) t;
        ContentValues values = new ContentValues();
        values.put("name", person.getName());
        values.put("age", person.getAge());
        long count = getDateBase().insert("person", null, values);
        Logger.logInfo("insert result = " + count);
    }

    @Override
    protected void delete(Object obj) {
        Person person = (Person) obj;
        ContentValues values = new ContentValues();
        values.put("name", person.getName());
        values.put("age", person.getAge());
        long count = getDateBase().delete("person", "name=?", new String[]{(String) values.get("name")});
        Logger.logInfo("insert result = " + count);
    }

    @Override
    protected void update(Object obj) {
        Person person = (Person) obj;
        ContentValues values = new ContentValues();
        values.put("name", person.getName());
        values.put("age", person.getAge());
        long count = getDateBase().update("person", values, "name=?", new String[]{(String) values.get("name")});
        Logger.logInfo("update result = " + count);
    }
}
