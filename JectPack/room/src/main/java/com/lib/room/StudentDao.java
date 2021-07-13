package com.lib.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
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
public interface StudentDao {
    /**
     * 查询所有学生
     *
     * @return List<Student>
     */
    @Query("SELECT * FROM stu")
    List<Student> getAll();

    /**
     * 获取比指定年龄大的学生
     *
     * @param minAge 学生最小年龄
     * @return List<Student>
     */
    @Query("SELECT * FROM stu WHERE age > :minAge")
    List<Student> loadAllByAge(int minAge);

    /**
     * 通过年龄范围查找学生
     *
     * @param minAge 最小年龄
     * @param maxAge 最大年龄
     * @return List<Student>
     */
    @Query("SELECT * FROM stu WHERE age BETWEEN :minAge AND :maxAge")
    List<Student> loadAllStudentBetweenAges(int minAge, int maxAge);

    /**
     * 插入学生
     *
     * @param student 学生
     * @return 数据库行数
     */
    @Insert
    long insert(Student student);

    /**
     * 删除学生
     *
     * @param student 学生
     */
    @Delete
    void delete(Student student);

    /**
     * 更新学生
     *
     * @param student 学生
     */
    @Update
    void update(Student student);
}
