package com.lib.room.mapping;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import java.util.List;

/**
 * @author :huangguofeng
 * date    :2021/1/23
 * package :com.lib.room.mapping
 * desc    :一对多关系 用户可以将其歌曲整理到播放列表中。每个用户可以创建任意数量的播放列表，但每个播放列表只能由一个用户创建，这就是一对多关系
 * TODO 注意：使用嵌套关系查询数据需要 Room 处理大量数据，可能会影响性能。因此，请在查询中尽量少用嵌套关系
 */
public class OneToMore {
    @Entity
    public class User {
        @PrimaryKey
        public long uid;
        public String name;
        public int age;
    }

    @Entity
    public class Playlist {
        @PrimaryKey
        public long playlistId;
        public long userCreatorId;
        public String playlistName;
    }

    public class UserWithPlaylists {
        @Embedded
        public User user;
        @Relation(
                parentColumn = "uid",
                entityColumn = "userCreatorId"
        )
        public List<Playlist> playlists;

//    向DAO类添加一个方法，用于返回将父实体与子实体配对的数据类的所有实例。该方法需要Room运行两次查询，因此应向该方法添加@Transaction注释，以确保整个操作以原子方式执行
//    @Transaction
//    @Query("SELECT * FROM User")
//    public List<UserWithPlaylists> getUsersWithPlaylists();

    }
}
