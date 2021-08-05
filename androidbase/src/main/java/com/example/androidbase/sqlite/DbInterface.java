package com.example.androidbase.sqlite;

import java.util.List;

/**
 * @author :huangguofeng
 * date    :2021/8/5
 * package :com.example.androidbase.sqlite
 * desc    :
 */
public interface DbInterface {
    /**
     * 查询
     **/
    List<Person> checkAll();

    /**
     * 添加
     **/
    void insert(Person person);

    /**
     * 删除
     **/
    void delete(Person person);

    /**
     * 更新
     **/
    void update(Person person);
}
