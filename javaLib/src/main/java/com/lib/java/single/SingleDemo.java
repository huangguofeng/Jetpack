package com.lib.java.single;

/**
 * @author :huangguofeng
 * date    :2021/7/17
 * package :com.lib.java.single
 * desc    :
 */
public class SingleDemo {
    public static void main(String[] args) {
        SingleA.getInstance().print("1");
        SingleB.getInstance().print("22");
        SingleC.getInstance().print("333");
        SingleD.getInstance().print("4444");
    }
}
