package com.lib.java.bridge;

/**
 * @author :huangguofeng
 * date    :2021/7/18
 * package :com.lib.java.bridge
 * desc    :图形抽象类，持有颜色接口对象
 */
public abstract class Shape {
    protected Color color;

    protected Shape(Color c) {
        this.color = c;
    }

    abstract void draw(String shape);
}
