package com.lib.java.decorator;

/**
 * @author :huangguofeng
 * date    :2021/7/18
 * package :com.lib.java.decorator
 * desc    :装饰类 实现被装饰类接口
 * 抽象类持有接口对象，接口对象由构造器赋值，并且自身实现该接口，实现接口方法，方法内部使用持有的接口对象去调用接口方法
 * 额外的装饰功能在接口方法内增加实现
 * 该装饰器不需要子类，如果需要则生命该类抽象，子类重写接口方法，重写的方法内调用父类的接口方法或者使用父类接口对象调用接口方法
 */
public class ShapeDecorator2 implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator2(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setGreenBorder();
    }

    private void setGreenBorder() {
        System.out.println("边框色: 绿色");
    }
}
