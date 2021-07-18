package com.lib.java.bridge;

/**
 * @author :huangguofeng
 * date    :2021/7/18
 * package :com.lib.java.bridge
 * desc    :扩充抽象类
 */
public class Square extends Shape {

    public Square(Color color) {
        super(color);
    }

    @Override
    void draw(String shape) {
        color.color(shape);
    }
}
