package com.lib.java.decorator;

/**
 * @author :huangguofeng
 * date    :2021/7/18
 * package :com.lib.java.decorator
 * desc    :实体装饰类 增加装饰功能的类
 * 该实体装饰类重写父类所继承的接口方法，保持父类对于接口方法的实现，然后额外的增加setBlueBorder功能
 */
public class BlueShapeDecorator extends ShapeDecorator {

    public BlueShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        super.draw();
        setBlueBorder(decoratedShape);
    }

    private void setBlueBorder(Shape decoratedShape) {
        System.out.println("边框色: 蓝色");
    }
}
