package com.lib.java.builder;

/**
 * @author :huangguofeng
 * date    :2021/7/17
 * package :com.lib.java.builder
 * desc    :具体的建造者角色，不同的建造者角色具有相同的构建过程但是可以有有不同的表现
 */
public class HwPhoneBuilder extends PhoneBuilder {
    private Phone phone = new Phone();

    @Override
    void buildBody() {
        phone.setBody("华为玻璃机身");
    }

    @Override
    void buildScreen() {
        phone.setScreen("华为液晶屏");
    }

    @Override
    void buildBattery() {
        phone.setBattery("华为锂电池");
    }

    @Override
    void buildProcessor() {
        phone.setProcessor("华为麒麟处理器");
    }

    @Override
    void buildChip() {
        phone.setChip("华为海思芯片");
    }

    @Override
    void buildUsb() {
        phone.setUsb("华为3.0USB");
    }

    @Override
    void buildErJi() {
        phone.setErJi("华为运动耳机");
    }

    @Override
    Phone build() {
        return phone;
    }
}
