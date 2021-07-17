package com.lib.java.builder;

/**
 * @author :huangguofeng
 * date    :2021/7/17
 * package :com.lib.java.builder
 * desc    :建造者角色，定义建造的过程有哪些
 */
public abstract class PhoneBuilder {
    /**
     * 机身
     */
    abstract void buildBody();
    /**
     * 屏幕
     */
    abstract void buildScreen();
    /**
     * 电池
     */
    abstract void buildBattery();
    /**
     * 处理器
     */
    abstract void buildProcessor();
    /**
     * 芯片
     */
    abstract void buildChip();
    /**
     * Usb
     */
    abstract void buildUsb();
    /**
     * 耳机孔
     */
    abstract void buildErJi();
    /**
     * 建造目标产品手机
     *
     * @return Phone
     */
    abstract Phone build();
}
