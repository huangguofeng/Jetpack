package com.lib.java.composite;

/**
 * @author :huangguofeng
 * date    :2021/7/18
 * package :com.lib.java.composite
 * desc    :
 */
public class VideoFile extends File {
    public VideoFile(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("这是影像文件，文件名：" + super.getName());
    }
}
