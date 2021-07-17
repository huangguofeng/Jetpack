package com.lib.java.single;

/**
 * @author :huangguofeng
 * date    :2021/7/17
 * package :com.lib.java.single
 * desc    :懒汉式单例模式
 * 只在调用getInstance方法的时候才去实例化对象。节约内存开销
 * 构造函数限定为private，来避免外部对象直接创建Singleton的对象 ，只能通过getInstance()方法来实例化对象。
 * 这种情况在多线程是也有可能创建出多个对象的，比如两个子线程同时不分先后同时调用getInstance()
 */
public class SingleB {
    private static SingleB singleB = null;
    private SingleB(){

    }
    public static SingleB getInstance() {
        if(singleB == null){
            singleB = new SingleB();
        }
        return singleB;
    }

}
