package com.lib.room;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;

/**
 * @author :huangguofeng
 * date    :2021/1/23
 * package :com.lib.room
 * desc    :
 * <p>
 * primaryKeys定义复合主键
 * tableName定义表名，默认为类名，表名称不区分大小写
 * ignoredColumns:定义忽略父实体的属性
 */
@Entity(primaryKeys = {"name", "sex"}, tableName = "stu", ignoredColumns = "phone")
public class Student extends User {

    public String name;
    public String sex;

    @ColumnInfo(name = "age")
    public int age;

    /**
     * 嵌套对象，使用后该实体在数据库中没有address这个列，会包含Address内部属性所有的列，并且是组合在一起不分割的
     */
    @Embedded
    public Address address;
}
