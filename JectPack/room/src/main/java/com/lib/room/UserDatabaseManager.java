package com.lib.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.lib.utils.Logger;


/**
 * @author :huangguofeng
 * date    :2021/1/21
 * package :com.lib.room
 * desc    :
 */
public class UserDatabaseManager {
    private static final String TAG = "[UserDatabaseManager]: ";
    private static UserDatabaseManager userDatabaseManager;
    private UserDatabase userDatabase;

    private UserDatabaseManager() {
    }

    public static UserDatabaseManager get() {
        if (userDatabaseManager == null) {
            synchronized (UserDatabaseManager.class) {
                if (userDatabaseManager == null) {
                    userDatabaseManager = new UserDatabaseManager();
                }
            }
        }
        return userDatabaseManager;
    }

    public synchronized UserDatabase getUserDatabase(Context context, String databaseName) {
        if (userDatabase != null) {
            return userDatabase;
        }
        userDatabase = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, databaseName)
                .addMigrations(MIGRATION_1_2).addCallback(callback).build();
        return userDatabase;
    }

    private static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
//            database.execSQL("CREATE TABLE `Fruit` (`id` INTEGER, " + "`name` TEXT, PRIMARY KEY(`id`))");
            Logger.logDebug(TAG, "数据库版本：" + database.getVersion() + ", 路径：" + database.getPath());
        }
    };

    private RoomDatabase.Callback callback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            Logger.logDebug(TAG, "数据库onCreate 版本：" + db.getVersion() + ", 路径：" + db.getPath());
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            Logger.logDebug(TAG, "数据库onOpen 版本：" + db.getVersion() + ", 路径：" + db.getPath());
        }

        @Override
        public void onDestructiveMigration(@NonNull SupportSQLiteDatabase db) {
            super.onDestructiveMigration(db);
            Logger.logDebug(TAG, "数据库onDestructiveMigration 版本：" + db.getVersion() + ", 路径：" + db.getPath());
        }
    };


}
