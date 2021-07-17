package com.lib.java.builder;

/**
 * @author :huangguofeng
 * date    :2021/7/17
 * package :com.lib.java.builder
 * desc    :
 */
public class Phone {
    private String body;
    private String screen;
    private String battery;
    private String processor;
    private String chip;
    private String usb;
    private String erJi;

    public Phone(){

    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public void setUsb(String usb) {
        this.usb = usb;
    }

    public void setErJi(String erJi) {
        this.erJi = erJi;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "body='" + body + '\'' +
                ", screen='" + screen + '\'' +
                ", battery='" + battery + '\'' +
                ", processor='" + processor + '\'' +
                ", chip='" + chip + '\'' +
                ", usb='" + usb + '\'' +
                ", erJi='" + erJi + '\'' +
                '}';
    }
}
