package com.lib.java.factory;

/**
 * @author :huangguofeng
 * date    :2021/7/17
 * package :com.lib.java.factory
 * desc    :具体实施工厂行为实现类
 */
public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("draw circle");
    }
}
