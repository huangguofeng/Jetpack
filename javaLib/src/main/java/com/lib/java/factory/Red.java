package com.lib.java.factory;

/**
 * @author :huangguofeng
 * date    :2021/7/17
 * package :com.lib.java.factory
 * desc    :具体实施工厂行为实现类
 */
public class Red implements Color{
    @Override
    public void color() {
        System.out.println("color red");
    }
}
