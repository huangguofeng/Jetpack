package com.lib.java.bridge;

/**
 * @author :huangguofeng
 * date    :2021/7/18
 * package :com.lib.java.bridge
 * desc    :图形抽象类，持有颜色接口对象
 * 抽象类持有接口对象，接口对象由构造器赋值，并且自身不实现接口,定义抽象方法由子类进行实现，方法名随意
 */
public abstract class Shape {
    protected Color color;

    protected Shape(Color c) {
        this.color = c;
    }

    abstract void draw(String shape);
}
