package com.lib.java.prototype;

/**
 * @author :huangguofeng
 * date    :2021/7/18
 * package :com.lib.java.prototype
 * desc    :原型模式demo
 * 1：原型模式（Prototype Pattern）是用于创建重复的对象，同时又能保证性能
 * 2：这种模式是实现了一个原型接口，该接口用于创建当前对象的克隆。当直接创建对象的代价比较大时，则采用这种模式
 * 3：例如，一个对象需要在一个高代价的数据库操作之后被创建。我们可以缓存该对象，在下一个请求时返回它的克隆，在需要的时候更新数据库，以此来减少数据库调用
 */
public class ProtoTypeDemo {
    /**
     * 赋值：
     * 1：赋值操作产生的对象和原对象共有相同的指针com.lib.java.prototype.Phone@70dea4e,目标指向同一个内存地址
     * 2：修改赋值对象或者原对象时，另外一方也会跟着改变，因为他们共有一个地址，操作同一块内存空间
     * 拷贝：按照拷贝的程度分一下两类
     * 浅拷贝：克隆对象和原对象中，基本数据类型成员变化时互不影响，引用数据类型成员变化时，一起变化
     * 1、当原型对象的成员变量是基本数据类型时，浅拷贝会复制该属性的值赋值给新对象，任一对象修改基本类型的成员变量值都不会影响对方对象的成语变量
     * 2、当原型对象的成员变量是引用数据类型时，浅拷贝复制的是引用数据类型的地址值。这种情况下，当拷贝出的某一个类修改了引用数据类型的成员变量后，会导致所有拷贝出的类都发生改变。
     * 3、浅拷贝实现：只针对原型对象本身进行克隆操作，成员变量不处理
     * 深拷贝：克隆对象和原对象完全独立，互不影响
     * 1、深拷贝不仅会复制成员变量为基本数据类型的值，给新对象。还会给是引用数据类型的成员变量申请储存空间，并复制引用数据类型成员变量的对象。
     * 2、这样拷贝出的新对象就不怕修改了是引用数据类型的成员变量后，对其它拷贝出的对象造成影响了
     * 3、深拷贝实现：原型类和其成员的引用对象分别进行克隆，或者原型类和内部引用对象同时实现序列化，然后序列化方式深度拷贝，或者分别对
     * 原型模式的优点及适用场景：
     * 1：使用原型模式创建对象比直接new一个对象在性能上要好的多，因为Object类的clone方法是一个本地方法，它直接操作内存中的二进制流，特别是复制大对象时，性能的差别非常明显
     * 2：使用原型模式的另一个好处是简化对象的创建，使得创建对象就像我们在编辑文档时的复制粘贴一样简单
     * 3：在需要重复地创建相似对象时可以考虑使用原型模式。比如在一个循环体内创建对象，使用原型模式不但可以简化创建过程，而且可以使系统的整体性能提高很多
     * 原型模式的注意事项：
     * 1：使用原型模式复制对象不会调用类的构造方法。因为对象的复制是通过调用Object类的clone方法来完成的，它直接在内存中复制数据，因此不会调用到类的构造方法。
     * 不但构造方法中的代码不会执行，甚至连访问权限都对原型模式无效。还记得单例模式吗？单例模式中，只要将构造方法的访问权限设置为private型，就可以实现单例。
     * 但是clone方法直接无视构造方法的权限，所以，单例模式与原型模式是冲突的，在使用时要特别注意。
     * 2：Object类的clone方法只会拷贝对象中的基本的数据类型，对于数组、容器对象、引用对象等都不会拷贝，就是浅拷贝。要实现深拷贝，必须将这些成员另行拷贝
     */
    public static void main(String[] args) {
        Pack pack = new Pack("精心包装", 200);
        Config config = new Config("液晶屏", 6);
        Phone phone = new Phone("华为", 4888);
        phone.setConfig(config);
        phone.setPack(pack);

        Phone phone1 = (Phone) phone.clone();
        Phone phone2 = phone;

        System.out.println(phone.getName() + "   " + phone.getPrice() + " , " + phone.getConfig().getScreen() + "  " + phone.getConfig().getSize() +
                " , " + phone.getPack().getScreen() + "   " + phone.getPack().getType());
        System.out.println(phone1.getName() + "   " + phone1.getPrice() + " , " + phone1.getConfig().getScreen() + "  " + phone1.getConfig().getSize() +
                " , " + phone1.getPack().getScreen() + "   " + phone1.getPack().getType());
        System.out.println(phone2.getName() + "   " + phone2.getPrice() + " , " + phone2.getConfig().getScreen() + "  " + phone2.getConfig().getSize() +
                " , " + phone2.getPack().getScreen() + "   " + phone2.getPack().getType());
        System.out.println(phone + "  " + phone.getPack() + "  " + phone.getConfig());
        System.out.println(phone1 + "  " + phone1.getPack() + "  " + phone1.getConfig());
        System.out.println(phone2 + "  " + phone2.getPack() + "  " + phone2.getConfig());

        phone.setName("OPPO");
        phone.getConfig().setScreen("磨砂屏");
        phone.getPack().setType(201);
        System.out.println(phone.getName() + "   " + phone.getPrice() + " , " + phone.getConfig().getScreen() + "  " + phone.getConfig().getSize() +
                " , " + phone.getPack().getScreen() + "   " + phone.getPack().getType());
        System.out.println(phone1.getName() + "   " + phone1.getPrice() + " , " + phone1.getConfig().getScreen() + "  " + phone1.getConfig().getSize() +
                " , " + phone1.getPack().getScreen() + "   " + phone1.getPack().getType());
        System.out.println(phone2.getName() + "   " + phone2.getPrice() + " , " + phone2.getConfig().getScreen() + "  " + phone2.getConfig().getSize() +
                " , " + phone2.getPack().getScreen() + "   " + phone2.getPack().getType());
        System.out.println(phone + "  " + phone.getPack() + "  " + phone.getConfig());
        System.out.println(phone1 + "  " + phone1.getPack() + "  " + phone1.getConfig());
        System.out.println(phone2 + "  " + phone2.getPack() + "  " + phone2.getConfig());

        phone2.setPrice(6666);
        phone2.getConfig().setSize(7);
        phone2.getPack().setScreen("简单包装");
        System.out.println(phone.getName() + "   " + phone.getPrice() + " , " + phone.getConfig().getScreen() + "  " + phone.getConfig().getSize() +
                " , " + phone.getPack().getScreen() + "   " + phone.getPack().getType());
        System.out.println(phone1.getName() + "   " + phone1.getPrice() + " , " + phone1.getConfig().getScreen() + "  " + phone1.getConfig().getSize() +
                " , " + phone1.getPack().getScreen() + "   " + phone1.getPack().getType());
        System.out.println(phone2.getName() + "   " + phone2.getPrice() + " , " + phone2.getConfig().getScreen() + "  " + phone2.getConfig().getSize() +
                " , " + phone2.getPack().getScreen() + "   " + phone2.getPack().getType());
        System.out.println(phone + "  " + phone.getPack() + "  " + phone.getConfig());
        System.out.println(phone1 + "  " + phone1.getPack() + "  " + phone1.getConfig());
        System.out.println(phone2 + "  " + phone2.getPack() + "  " + phone2.getConfig());

        phone1.setPrice(8888);
        phone1.getConfig().setSize(8);
        phone1.getPack().setScreen("0包装");
        System.out.println(phone.getName() + "   " + phone.getPrice() + " , " + phone.getConfig().getScreen() + "  " + phone.getConfig().getSize() +
                " , " + phone.getPack().getScreen() + "   " + phone.getPack().getType());
        System.out.println(phone1.getName() + "   " + phone1.getPrice() + " , " + phone1.getConfig().getScreen() + "  " + phone1.getConfig().getSize() +
                " , " + phone1.getPack().getScreen() + "   " + phone1.getPack().getType());
        System.out.println(phone2.getName() + "   " + phone2.getPrice() + " , " + phone2.getConfig().getScreen() + "  " + phone2.getConfig().getSize() +
                " , " + phone2.getPack().getScreen() + "   " + phone2.getPack().getType());
        System.out.println(phone + "  " + phone.getPack() + "  " + phone.getConfig());
        System.out.println(phone1 + "  " + phone1.getPack() + "  " + phone1.getConfig());
        System.out.println(phone2 + "  " + phone2.getPack() + "  " + phone2.getConfig());
        main1(args);
    }

    /**
     *
     */
    public static void main1(String[] args) {
        System.out.println("==============================");
        System.out.println("==============================");
        System.out.println("==============================");
        Pack pack = new Pack("精心包装", 200);
        Config config = new Config("液晶屏", 6);
        PhonePro phone = new PhonePro("华为", 4888);
        phone.setConfig(config);
        phone.setPack(pack);

        PhonePro phone1 = phone.deepCopy();
        System.out.println(phone + "  " + phone.getPack() + "  " + phone.getConfig());
        System.out.println(phone1 + "  " + phone1.getPack() + "  " + phone1.getConfig());

        System.out.println(phone.getName() + "   " + phone.getPrice() + " , " + phone.getConfig().getScreen() + "  " + phone.getConfig().getSize() +
                " , " + phone.getPack().getScreen() + "   " + phone.getPack().getType());
        System.out.println(phone1.getName() + "   " + phone1.getPrice() + " , " + phone1.getConfig().getScreen() + "  " + phone1.getConfig().getSize() +
                " , " + phone1.getPack().getScreen() + "   " + phone1.getPack().getType());

        phone.setName("OPPO");
        phone.getConfig().setScreen("磨砂屏");
        phone.getPack().setType(201);
        System.out.println(phone.getName() + "   " + phone.getPrice() + " , " + phone.getConfig().getScreen() + "  " + phone.getConfig().getSize() +
                " , " + phone.getPack().getScreen() + "   " + phone.getPack().getType());
        System.out.println(phone1.getName() + "   " + phone1.getPrice() + " , " + phone1.getConfig().getScreen() + "  " + phone1.getConfig().getSize() +
                " , " + phone1.getPack().getScreen() + "   " + phone1.getPack().getType());


        phone1.setPrice(8888);
        phone1.getConfig().setSize(8);
        phone1.getPack().setScreen("0包装");
        System.out.println(phone.getName() + "   " + phone.getPrice() + " , " + phone.getConfig().getScreen() + "  " + phone.getConfig().getSize() +
                " , " + phone.getPack().getScreen() + "   " + phone.getPack().getType());
        System.out.println(phone1.getName() + "   " + phone1.getPrice() + " , " + phone1.getConfig().getScreen() + "  " + phone1.getConfig().getSize() +
                " , " + phone1.getPack().getScreen() + "   " + phone1.getPack().getType());
    }
}
