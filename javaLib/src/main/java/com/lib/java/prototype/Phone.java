package com.lib.java.prototype;

/**
 * @author :huangguofeng
 * date    :2021/7/18
 * package :com.lib.java.prototype
 * desc    :原型类，内部有基本成员和引用类型成员
 */
public class Phone implements Cloneable {

    private String name;
    private int price;
    private Config config;
    private Pack pack;

    public Phone(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Pack getPack() {
        return pack;
    }

    public void setPack(Pack pack) {
        this.pack = pack;
    }

    /**
     * 大量产生简单的对象 使用克隆进行浅拷贝
     */
    @Override
    protected Object clone() {
        Phone phone = null;
        try {
            /**
             * 克隆操作
             * 1：本类克隆
             * 2：内部成员实现克隆接口的pack进行克隆
             * 3：未实现接口的config不做克隆
             */
            phone = (Phone) super.clone();
            phone.pack = (Pack) this.pack.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return phone;
    }
}
