package com.lib.java.adapter;

/**
 * @author :huangguofeng
 * date    :2021/7/19
 * package :com.lib.java.adapter
 * desc    :对象适配器
 * 不继承适配者，声明适配器类型的成员变量，构造器进行赋值
 * 实现接口，实现接口方法，方法内部使用适配器成员变量调用适配者方法
 */
public class ObjectAdapter implements Usb {
    private TypeC typeC;

    public ObjectAdapter(TypeC t) {
        typeC = t;
    }

    @Override
    public void connect() {
        System.out.println(" 对象适配器 开始适配 ");
        typeC.typeC();
    }
}
