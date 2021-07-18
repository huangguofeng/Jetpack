package com.lib.java.bridge;

/**
 * @author :huangguofeng
 * date    :2021/7/18
 * package :com.lib.java.bridge
 * desc    :扩充抽象类
 */
public class Circle extends Shape {

    public Circle(Color color) {
        super(color);
    }

    @Override
    void draw(String shape) {
        color.color(shape);
    }
}
