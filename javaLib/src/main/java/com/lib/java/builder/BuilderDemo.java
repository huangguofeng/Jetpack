package com.lib.java.builder;

/**
 * @author :huangguofeng
 * date    :2021/7/17
 * package :com.lib.java.builder
 * desc    :建造者模式demo
 * 1：使用多个简单的对象一步一步构建成一个复杂的对象
 * 2：将一个复杂的构建与其表示相分离，使得同样的构建过程（builder抽象类定义的方法）可以创建不同的表示（不同的子继承类）
 * 3：主要解决在软件系统中，面临着"一个复杂对象"的创建工作，通常由子对象用一定的算法构成；这个复杂对象的各个部分可能面临着剧烈的变化，但是将它们组合在一起的算法却相对稳定
 * 4：何时使用：一些基本部件不会变，而其组合经常变化的时候。
 * 5：如何解决：将变与不变分离开。
 * 6：关键代码：builder：创建和提供实例，director：管理建造出来的实例的依赖关系
 * 7：使用场景： 1、需要生成的对象具有复杂的内部结构。 2、需要生成的对象内部属性本身相互依赖。
 * 8：注意事项：与工厂模式的区别是：建造者模式更加关注与零件装配的顺序
 */
public class BuilderDemo {
    public static void main(String[] args) {
        Computer computer = new Computer.Builder()
                .setName("IMAC")
                .setType("一体机")
                .setSize("27英寸")
                .setMake("美国")
                .setPrice("12888")
                .build();
        System.out.println(computer.toString());
        main1(args);
    }

    /**
     * 简单对象组成复杂对象，组成的步骤相对稳定，但是每一步具体的实施可能是有波动
     * 例如：手机需要屏幕，机身，电池，处理器，芯片，USB，耳机孔，这些有些是必须的，有些是非必须的
     * 组合过程是固定的，但是不同的配置高低产出的设备性能不一样，不同的厂商产出的设备型号不一样
     */
    public static void main1(String[] args) {
        // 实例化builder
        HwPhoneBuilder hwPhoneBuilder = new HwPhoneBuilder();
        // builder交给监工,监工处理组装
        Director director = new Director(hwPhoneBuilder);
        director.construct();
        // 监工组装好以后，建造者产出手机
        Phone phone = hwPhoneBuilder.build();
        System.out.println(phone.toString());

        ApplePhoneBuilder applePhoneBuilder = new ApplePhoneBuilder();
        Director director2 = new Director(applePhoneBuilder);
        director2.construct();
        Phone phone2 = applePhoneBuilder.build();
        System.out.println(phone2.toString());
    }
}
