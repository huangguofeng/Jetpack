package com.lib.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * @author :huangguofeng
 * date    :2021/1/21
 * package :com.lib.room
 * desc    :
 */
@Dao
public interface UserDao {
    /**
     * 查询所有用户
     *
     * @return List<User>
     */
    @Query("SELECT * FROM user")
    List<User> getAll();

    /**
     * 获取指定id的用户
     *
     * @param userIds 用户id集合
     * @return List<User>
     */
    @Query("SELECT * FROM user WHERE userId IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    /**
     * 通过用户姓 名查找用户
     *
     * @param first 姓
     * @param last  名
     * @return User
     */
    @Query("SELECT * FROM user WHERE firstName LIKE :first AND " + "lastName LIKE :last LIMIT 1")
    User findByName(String first, String last);

    /**
     * 只查出表里的姓名
     *
     * @return List<NameTuple>
     */
    @Query("SELECT firstName, lastName FROM user")
    List<NameTuple> loadFullName();

    /**
     * 只查出表里指定国家的用户姓名
     *
     * @param countries 指定国家范围
     * @return List<NameTuple>
     */
    @Query("SELECT firstName, lastName FROM user WHERE country IN (:countries)")
    List<NameTuple> loadUsersForCountry(List<String> countries);

    /**
     * 通过用户姓或名查找用户
     *
     * @param search 姓或名
     * @return List<User>
     */
    @Query("SELECT * FROM user WHERE firstName LIKE :search " + "OR lastName LIKE :search")
    List<User> findUserWithName(String search);

    /**
     * 批量插入用户 返回值可选long，表示数据的所在行数，批量插入返回long[]或List<Long>
     * onConflict:插入数据冲突处理方式：默认终止，可选忽略，可选强行插入
     *
     * @param users 用户
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User... users);

    /**
     * 批量插入用户
     * onConflict:插入数据冲突处理方式：默认终止，可选忽略，可选强行插入
     *
     * @param user 用户
     * @return 数据库行数
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertAll(User user);

    /**
     * 删除单一用户
     *
     * @param user 用户
     */
    @Delete
    void delete(User user);

    /**
     * 更新用户，返回值可选int，表示数据的所在行数
     *
     * @param user 用户
     */
    @Update
    void update(User user);
}
