package com.lib.java;

/**
 * @author huangguofeng
 * 设计模式是针对生活中实际问题的解决思路，在代码上的体现
 * 使用设计模式是为了重用代码、让代码更容易被他人理解、保证代码可靠性
 */
public class DesignPattern {
    /**
     * 设计思想：
     * 对接口编程而不是对实现编程
     * 优先使用对象组合而不是继承
     */
    /**
     * 设计原则
     *
     * 单一职责：功能要纯粹
     * 开闭原则：对扩展开放，对修改关闭。在程序需要进行拓展的时候，不能去修改原有的代码，实现一个热插拔的效果
     * 里式替换原则：任何基类可以出现的地方，子类一定可以出现
     * 依赖倒置原则：针对接口编程，依赖于抽象而不依赖于具体
     * 接口隔离原则：使用多个隔离的接口，比使用单个接口要好，降低类之间的耦合度
     * 合成复用原则：尽量使用合成/聚合的方式，而不是使用继承
     * 迪米特法则：一个实体应当尽量少地与其他实体之间发生相互作用，使得系统功能模块相对独立
     */
    /**
     * 设计模式分类：
     * <p>
     * 1 创建型：工厂模式，抽象工厂模式，单例模式，建造者模式，原型模式
     * 2 结构型：适配器模式，代理模式，外观模式，装饰器模式，组合模式，享元模式，桥接模式，过滤器模式
     * 3 行为型：模板模式，观察者模式，策略模式，责任链模式，命令模式，解释器模式，迭代器模式，中介者模式，备忘录模式，状态模式，空对象模式，访问者模式
     */
    public static void main(String[] args) {
        System.out.println("main");
        System.gc();
    }
}