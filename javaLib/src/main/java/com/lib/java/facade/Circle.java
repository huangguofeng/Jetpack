package com.lib.java.facade;

/**
 * @author :huangguofeng
 * date    :2021/7/18
 * package :com.lib.java.facade
 * desc    :
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("图形: 圆形");
    }
}
