package com.lib.java.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author :huangguofeng
 * date    :2021/7/18
 * package :com.lib.java.prototype
 * desc    :原型类，内部有基本成员和引用类型成员
 */
public class PhonePro implements Serializable {

    private String name;
    private int price;
    private Config config;
    private Pack pack;

    public PhonePro(String name, int price) {
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
     * 通过序列化对象实现深拷贝。
     * 推荐使用该方式：
     * 因为一般需要使用克隆操作的要么是复杂的大型对象，层层向下包含多个引用对象，产出条件比较复杂，增删某一个子对象时，还要修改克隆操作
     * 使用该方式则无需要这么复杂的工作，使目标实现序列化接口即可
     */
    public PhonePro deepCopy() {
        // 声明流对象
        ByteArrayOutputStream bos = null;
        ByteArrayInputStream bis = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            //创建序列化流
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            // 将当前对象以对象流的方式输出
            oos.writeObject(this);
            // 创建反序列化流
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            // 将流对象反序列化，从而实现类的深拷贝。
            return (PhonePro) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                bos.close();
                bis.close();
                oos.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
