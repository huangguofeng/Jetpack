package com.lib.java.prototype;

import java.io.Serializable;

/**
 * @author :huangguofeng
 * date    :2021/7/18
 * package :com.lib.java.prototype
 * desc    :实现克隆和序列化接口的引用类型对象
 */
public class Pack implements Serializable, Cloneable {
    private String pack;
    private int type;

    public Pack(String screen, int type) {
        this.pack = screen;
        this.type = type;
    }

    public String getScreen() {
        return pack;
    }

    public void setScreen(String screen) {
        this.pack = screen;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
