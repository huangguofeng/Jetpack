package com.lib.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Fts4;
import androidx.room.PrimaryKey;

/**
 * @author :huangguofeng
 * date    :2021/1/23
 * package :com.lib.room
 * desc    :
 * <p>
 * Fts4:全文搜索虚拟表声明
 * languageId:多语言支持
 */
@Fts4(languageId = "lan")
@Entity(tableName = "Author")
public class Author extends User {
    /**
     * 启用 FTS 的表始终使用 INTEGER 类型的主键且列名称为“rowid”
     */
    @PrimaryKey
    @ColumnInfo(name = "rowid")
    public int id;

    @ColumnInfo(name = "lan")
    public int languageId;

    public String address;
    public String mail;
}
