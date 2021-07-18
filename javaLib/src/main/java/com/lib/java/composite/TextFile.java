package com.lib.java.composite;

/**
 * @author :huangguofeng
 * date    :2021/7/18
 * package :com.lib.java.composite
 * desc    :
 */
public class TextFile extends File {
    public TextFile(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("这是文本文件，文件名：" + super.getName());
    }
}
