package com.lib.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * @author :huangguofeng
 * date    :2021/1/21
 * package :com.lib.room
 * desc    :
 * <p>
 * indices:将数据库中的某些列编入索引，以加快查询速度
 * Index:定义编入索引的列名
 * unique:保持索引的唯一性
 */
@Entity(indices = {@Index("country"), @Index(value = {"firstName", "lastName"}, unique = true)})
public class User {
    /**
     * userId 用户id
     * PrimaryKey定义主键，autoGenerate可选：设置自动增长
     */
    @PrimaryKey(autoGenerate = true)
    public int userId;

    /**
     * 用户姓
     * ColumnInfo定义列名，如果未设置，默认使用字段名
     */
    @ColumnInfo(name = "firstName")
    public String first_name;

    /**
     * 用户名
     */
    @ColumnInfo(name = "lastName")
    public String last_name;

    /**
     * 用户所在国家
     */
    @ColumnInfo(name = "country")
    public String country_code;

    /**
     * 用户手机号
     * 默认情况下，Room 会为实体中定义的每个字段创建一个列。如果某个实体中有您不想保留的字段，则可以使用 @Ignore 为这些字段添加注释
     */
    @Ignore
    public String phone;

}
