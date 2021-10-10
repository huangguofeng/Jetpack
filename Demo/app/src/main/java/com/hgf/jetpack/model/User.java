package com.hgf.jetpack.model;

/**
 * @author :huangguofeng
 * date    :2020/6/22
 * package :com.hgf.jetpack.model
 * desc    :用户信息实体类
 */
public class User {
    private String name;
    private String pwd;

    public User() {

    }

    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
