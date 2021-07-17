package com.lib.java.single;

/**
 * @author :huangguofeng
 * date    :2021/7/17
 * package :com.lib.java.single
 * desc    :懒汉式单例模式加锁双重判断模式
 * 加锁，双重判定null，解决多线程多次创建对象问题
 * 假设两个线程同时调用，由于synchronized锁定，只有一个进去方法体，一个等待锁释放，
 * 其中一个进去后实例化对象执行完毕，另外一个进去后会再次判断null，避免二次实例化对象
 */
public class SingleC {
    private static SingleC singleC = null;
    private SingleC(){

    }
    public static SingleC getInstance() {
        if(singleC == null){
            synchronized(SingleC.class){
                if(singleC == null){
                    singleC = new SingleC();
                }
            }
        }
        return singleC;
    }

}
