package com.lib.java.facade;

/**
 * @author :huangguofeng
 * date    :2021/7/18
 * package :com.lib.java.facade
 * desc    :
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("图形: 长方形");
    }
}