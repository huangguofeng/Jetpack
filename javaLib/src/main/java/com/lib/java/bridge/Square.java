package com.lib.java.bridge;

/**
 * @author :huangguofeng
 * date    :2021/7/18
 * package :com.lib.java.bridge
 * desc    :扩充抽象类
 * 该实体实现父类定义的抽象方法，在该方法内使用父类成员变量的接口类对象去调用接口的方法
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
