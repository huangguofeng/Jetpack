package com.lib.java.composite;

/**
 * @author :huangguofeng
 * date    :2021/7/18
 * package :com.lib.java.composite
 * desc    :
 */
public abstract class File {
    String name;

    public File(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void display();
}
