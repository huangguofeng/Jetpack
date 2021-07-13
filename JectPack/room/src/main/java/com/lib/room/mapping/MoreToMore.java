package com.lib.room.mapping;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Junction;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import java.util.List;

/**
 * @author :huangguofeng
 * date    :2021/1/23
 * package :com.lib.room.mapping
 * desc    :每个播放列表都可以包含多首歌曲，每首歌曲都可以包含在多个不同的播放列表中。因此，Playlist 实体和 Song 实体之间应存在多对多的关系。
 * TODO 注意：使用嵌套关系查询数据需要 Room 处理大量数据，可能会影响性能。因此，请在查询中尽量少用嵌套关系
 */
public class MoreToMore {
    @Entity
    public class Playlist {
        @PrimaryKey
        public long playlistId;
        public String playlistName;
    }

    @Entity
    public class Song {
        @PrimaryKey
        public long songId;
        public String songName;
        public String artist;
    }

    @Entity(primaryKeys = {"playlistId", "songId"})
    public class PlaylistSongCrossRef {
        public long playlistId;
        public long songId;
    }

    public class PlaylistWithSongs {
        @Embedded
        public Playlist playlist;
        @Relation(
                parentColumn = "playlistId",
                entityColumn = "songId",
                associateBy = @Junction(PlaylistSongCrossRef.class)
        )
        public List<Song> songs;
    }

    public class SongWithPlaylists {
        @Embedded
        public Song song;
        @Relation(
                parentColumn = "songId",
                entityColumn = "playlistId",
                associateBy = @Junction(PlaylistSongCrossRef.class)
        )
        public List<Playlist> playlists;
    }


    /*
     * 向 DAO 类添加一个方法，用于提供您的应用所需的查询功能。
     *
     * getPlaylistsWithSongs：该方法会查询数据库并返回查询到的所有 PlaylistWithSongs 对象。
     * getSongsWithPlaylists：该方法会查询数据库并返回查询到的所有 SongWithPlaylists 对象。
     * 这两个方法都需要 Room 运行两次查询，因此应为这两个方法添加 @Transaction 注释，以确保整个操作以原子方式执行。
     */

//    @Transaction
//    @Query("SELECT * FROM Playlist")
//    public List<PlaylistWithSongs> getPlaylistsWithSongs();
//
//    @Transaction
//    @Query("SELECT * FROM Song")
//    public List<SongWithPlaylists> getSongsWithPlaylists();
}
