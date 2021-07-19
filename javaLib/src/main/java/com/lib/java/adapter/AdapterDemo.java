package com.lib.java.adapter;

/**
 * @author :huangguofeng
 * date    :2021/7/19
 * package :com.lib.java.adapter
 * desc    :适配器模式
 */
public class AdapterDemo {
    public static void main(String[] args) {
        Usb adapter = new ClassAdapter();
        TypeC typeC = new TypeC();
        Usb adapter2 = new ObjectAdapter(typeC);
        adapter.connect();
        adapter2.connect();
    }
}
