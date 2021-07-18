package com.lib.java.decorator;

/**
 * @author :huangguofeng
 * date    :2021/7/18
 * package :com.lib.java.decorator
 * desc    :实体装饰类 增加装饰功能的类
 * 该实体装饰类重写父类所继承的接口方法，保持父类对于接口方法的实现，然后额外的增加setRedBorder功能
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape) {
        System.out.println("边框色: 红色");
    }
}
