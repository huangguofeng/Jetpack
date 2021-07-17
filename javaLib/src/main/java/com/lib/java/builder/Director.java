package com.lib.java.builder;

/**
 * @author :huangguofeng
 * date    :2021/7/17
 * package :com.lib.java.builder
 * desc    :
 */
public class Director {
    private PhoneBuilder builder;

    public Director(PhoneBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(PhoneBuilder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.buildBody();
        builder.buildScreen();
        builder.buildBattery();
        builder.buildProcessor();
        builder.buildChip();
        builder.buildUsb();
        builder.buildErJi();
    }
}
