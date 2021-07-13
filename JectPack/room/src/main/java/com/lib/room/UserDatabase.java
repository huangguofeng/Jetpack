package com.lib.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * @author :huangguofeng
 * date    :2021/1/21
 * package :com.lib.room
 * desc    :UserDatabase
 */
@Database(entities = {User.class}, version = UserDatabase.version)
public abstract class UserDatabase extends RoomDatabase {
    /**
     * 获取userDao
     *
     * @return UserDao
     */
    public abstract UserDao userDao();

    public static final int version = 1;
}
