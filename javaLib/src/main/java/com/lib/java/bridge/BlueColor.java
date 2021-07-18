package com.lib.java.bridge;

/**
 * @author :huangguofeng
 * date    :2021/7/18
 * package :com.lib.java.bridge
 * desc    :蓝色实现类
 */
public class BlueColor implements Color {
    @Override
    public void color(String shape) {
        System.out.println("画蓝色：" + shape);
    }
}
