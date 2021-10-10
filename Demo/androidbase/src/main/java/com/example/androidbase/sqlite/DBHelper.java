package com.example.androidbase.sqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.androidbase.App;
import com.lib.utils.Logger;

/**
 * @author :huangguofeng
 * date    :2021/8/5
 * package :com.example.androidbase.sqlite
 * desc    :
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String NAME = "test.db";
    private static final int VERSION = 1;
    private static SQLiteDatabase INSTANCE;


    public SQLiteDatabase getInstance() {
        if (INSTANCE == null) {
            INSTANCE = getWritableDatabase();
        }
        return INSTANCE;
    }

    public DBHelper() {
        this(App.getContext(), NAME, null, VERSION);
    }

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public DBHelper(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Logger.logInfo("DBHelper 数据库onCreate");
        String createTable = "CREATE TABLE IF NOT EXISTS person(_id integer NOT NULL PRIMARY KEY AUTOINCREMENT,name text,age integer);";
        //创建表
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Logger.logInfo("DBHelper 数据库onUpgrade");
        //升级判断,如果再升级就要再加两个判断,从1到3,从2到3
        if (oldVersion == 1 && newVersion == 2) {
            db.execSQL("ALTER TABLE person ADD phone text;");
        }

    }
}
