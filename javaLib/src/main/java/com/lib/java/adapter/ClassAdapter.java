package com.lib.java.adapter;

/**
 * @author :huangguofeng
 * date    :2021/7/19
 * package :com.lib.java.adapter
 * desc    :类适配器
 * 继承适配者就能调用适配者类中需要的方法
 * 实现现有接口类可以调用接口方法
 * 接口方法中调用适配者的方法，就完成了适配：保持现有接口和方法不变，能够调用目标类的方法
 */
public class ClassAdapter extends TypeC implements Usb {
    @Override
    public void connect() {
        System.out.println(" 类适配器 开始适配 ");
        typeC();
    }
}
