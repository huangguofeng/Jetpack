package com.lib.room.mapping;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

/**
 * @author :huangguofeng
 * date    :2021/1/23
 * package :com.lib.room.mapping
 * desc    :一对一关系库 一个用户一个库，比如音乐播放器一个用户一个自己的曲库
 * TODO 注意：使用嵌套关系查询数据需要 Room 处理大量数据，可能会影响性能。因此，请在查询中尽量少用嵌套关系
 */
public class OneToOne {
    @Entity
    public class User {
        @PrimaryKey
        public long uid;
        public String name;
        public int age;
    }

    @Entity
    public class Library {
        @PrimaryKey
        public long libraryId;
        public long userOwnerId;
    }

    public class UserAndLibrary {
        @Embedded
        public User user;

        /**
         * parentColumn：父实体所在的id
         * entityColumn：子实体所在的id
         */
        @Relation(
                parentColumn = "uid",
                entityColumn = "userOwnerId"
        )
        public Library library;

    /*
        Dao获取UserAndLibrary实例的方式，因为Room需要查询两个表，需要查询两次，所以添加@Transaction注解，在子线程运行
     *  @Transaction
     *  @Query("SELECT * FROM User")
     *  public List<UserAndLibrary> getUsersAndLibraries();
     */
    }
}
