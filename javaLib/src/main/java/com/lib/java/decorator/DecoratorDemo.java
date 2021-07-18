package com.lib.java.decorator;

/**
 * @author :huangguofeng
 * date    :2021/7/18
 * package :com.lib.java.decorator
 * desc    :装饰器模式：允许向一个现有的对象添加新的功能，同时又不改变其结构
 * 这种模式创建了一个装饰类，用来包装原有的类，并在保持类方法签名完整性的前提下，提供了额外的功能。
 * 被装饰类：接口
 * 实际被装饰类：接口实现类
 * 装饰类：抽象类
 * 实体装饰类：抽象实体类
 * 总结：
 * 1：声明抽象类，实例化子类，参数为接口实现类
 * 2：抽象类持有接口对象，接口对象由构造器赋值，并且自身实现接口对象，实现接口方法，方法内部使用持有的接口对象去调用接口方法
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());

        redCircle.draw();
        System.out.println("\n");
        redRectangle.draw();
        System.out.println("\n");
        ShapeDecorator redCircle1 = new BlueShapeDecorator(new Circle());
        ShapeDecorator redRectangle1 = new BlueShapeDecorator(new Rectangle());

        redCircle1.draw();
        System.out.println("\n");
        redRectangle1.draw();
        System.out.println("\n");
        
        ShapeDecorator2 redCircle2 = new ShapeDecorator2(new Circle());
        ShapeDecorator2 redRectangle2 = new ShapeDecorator2(new Rectangle());

        redCircle2.draw();
        System.out.println("\n");
        redRectangle2.draw();
        System.out.println("\n");
    }
}
