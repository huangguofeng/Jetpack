package com.lib.java.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :huangguofeng
 * date    :2021/7/18
 * package :com.lib.java.composite
 * desc    :
 */
public class Folder extends File {
    private List<File> files;

    public Folder(String name) {
        super(name);
        files = new ArrayList<File>();
    }

    /**
     * 浏览文件夹中的文件
     */
    @Override
    public void display() {
        System.out.println("这是文件夹，名字：" + super.getName());
        for (File file : files) {
            file.display();
        }
    }

    public void add(File file) {
        files.add(file);
    }


    public void remove(File file) {
        files.remove(file);
    }
}
