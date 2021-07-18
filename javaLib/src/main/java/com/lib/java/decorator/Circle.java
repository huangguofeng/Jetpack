package com.lib.java.decorator;

/**
 * @author :huangguofeng
 * date    :2021/7/18
 * package :com.lib.java.decorator
 * desc    :被装饰的接口实现类
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("图形: 圆形");
    }
}
