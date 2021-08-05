package com.example.androidbase.sqlite;

import java.io.Serializable;

/**
 * @author :huangguofeng
 * date    :2021/8/5
 * package :com.example.androidbase.sqlite
 * desc    :
 */
public class Person implements Serializable {
    String name;
    int age;

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
