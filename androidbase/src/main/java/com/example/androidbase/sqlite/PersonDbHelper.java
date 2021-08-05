package com.example.androidbase.sqlite;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :huangguofeng
 * date    :2021/8/5
 * package :com.example.androidbase.sqlite
 * desc    :
 */
public class PersonDbHelper extends DatebaseHelper {

    private static PersonDbHelper personDbHelper;

    private PersonDbHelper() {

    }

    public static PersonDbHelper getInstance() {
        if (personDbHelper == null) {
            return new PersonDbHelper();
        }
        return personDbHelper;
    }


    @Override
    protected List<?> checkAll() {
        List<Person> list = new ArrayList<>();
        //COLLATE NOCASE 忽略大小写查询
        //Cursor cursor = getDateBase().rawQuery("select * from T_cpz where isqy='True' COLLATE NOCASE;", null);
        Cursor cursor = getDateBase().rawQuery("select * from person", null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                int age = cursor.getInt(cursor.getColumnIndex("age"));

                Person person = new Person();
                person.setName(name);
                person.setAge(age);
                list.add(person);
            }
            cursor.close();
        }
        return list;
    }

    @Override
    protected <T> void insert(T t) {
        Person person = (Person) t;
        // 占位符模式
        String sql = "insert into person(name,age) values(?,?)";
        getDateBase().execSQL(sql, new Object[]{person.getName(), person.getAge()});
    }

    @Override
    protected void delete(Object obj) {
        Person person = (Person) obj;
        String sql = "delete from person where name='" + person.getName() + "';";
        getDateBase().execSQL(sql);
    }

    @Override
    protected void update(Object obj) {
        Person person = (Person) obj;
        // 完整语句模式
        String sql = "update person set age=" + person.getAge() + " where name='" + person.getName() + "';";
        getDateBase().execSQL(sql);
    }
}
