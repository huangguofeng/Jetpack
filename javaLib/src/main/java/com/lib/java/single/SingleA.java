package com.lib.java.single;

/**
 * @author :huangguofeng
 * date    :2021/7/17
 * package :com.lib.java.single
 * desc    :饿汉式单例模式
 * 饿汉式单例模式，类加载时已经进行初始化，就已经实例化对象了，在被外部调用时，对象已存在，线程保证了安全性
 */
public class SingleA {
    public static SingleA singleA = new SingleA();

    public static SingleA getInstance() {
        return singleA;
    }

}
