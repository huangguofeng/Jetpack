package com.lib.java.decorator;

/**
 * @author :huangguofeng
 * date    :2021/7/18
 * package :com.lib.java.decorator
 * desc    :抽象装饰类 实现被装饰类接口
 * 抽象类持有接口对象，接口对象由构造器赋值，并且自身实现该接口，实现接口方法，方法内部使用持有的接口对象去调用接口方法
 */
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
