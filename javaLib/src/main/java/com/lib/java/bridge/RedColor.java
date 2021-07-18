package com.lib.java.bridge;

/**
 * @author :huangguofeng
 * date    :2021/7/18
 * package :com.lib.java.bridge
 * desc    :红色实现类
 */
public class RedColor implements Color {
    @Override
    public void color(String shape) {
        System.out.println("画红色：" + shape);
    }
}
