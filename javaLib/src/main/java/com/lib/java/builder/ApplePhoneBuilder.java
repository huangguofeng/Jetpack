package com.lib.java.builder;

/**
 * @author :huangguofeng
 * date    :2021/7/17
 * package :com.lib.java.builder
 * desc    :具体的建造者角色，不同的建造者角色具有相同的构建过程但是可以有有不同的表现
 */
public class ApplePhoneBuilder extends PhoneBuilder {
    private Phone phone = new Phone();

    @Override
    void buildBody() {
        phone.setBody("苹果磨砂机身");
    }

    @Override
    void buildScreen() {
        phone.setScreen("苹果玻璃屏");
    }

    @Override
    void buildBattery() {
        phone.setBattery("苹果里电池");
    }

    @Override
    void buildProcessor() {
        phone.setProcessor("苹果高通处理器");
    }

    @Override
    void buildChip() {
        phone.setChip("苹果A1芯片");
    }

    @Override
    void buildUsb() {
        phone.setUsb("苹果Type-C-USB");
    }

    @Override
    void buildErJi() {
        phone.setErJi("没有耳机孔");
    }

    @Override
    Phone build() {
        return phone;
    }
}
