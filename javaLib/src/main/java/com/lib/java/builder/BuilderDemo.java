package com.lib.java.builder;

import com.lib.java.single.SingleA;
import com.lib.java.single.SingleB;
import com.lib.java.single.SingleC;
import com.lib.java.single.SingleD;

/**
 * @author :huangguofeng
 * date    :2021/7/17
 * package :com.lib.java.single
 * desc    :建造者模式demo
 */
public class BuilderDemo {
    public static void main(String[] args) {
        Computer computer = new Computer.Builder()
                .setName("IMAC")
                .setType("一体机")
                .setSize("27英寸")
                .setMake("美国")
                .setPrice("12888")
                .build();
        System.out.println(computer.toString());
    }
}
