package com.lib.java.prototype;

import java.io.Serializable;

/**
 * @author :huangguofeng
 * date    :2021/7/18
 * package :com.lib.java.prototype
 * desc    :实现序列化未实现克隆接口的引用类型对象
 */
public class Config implements Serializable {
    private String screen;
    private int size;

    public Config(String screen, int size) {
        this.screen = screen;
        this.size = size;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
