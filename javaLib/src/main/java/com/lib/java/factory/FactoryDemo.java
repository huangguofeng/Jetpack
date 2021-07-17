package com.lib.java.factory;

/**
 * @author :huangguofeng
 * date    :2021/7/17
 * package :com.lib.java.factory
 * desc    :
 */
public class FactoryDemo {
    public static void main1(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("Circle");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("Square");
        shape2.draw();

        System.err.println("=========================");
        ColorFactory colorFactory = new ColorFactory();
        Color color1 = colorFactory.getColor("Red");
        color1.color();

        Color color2 = colorFactory.getColor("Blue");
        color2.color();

        System.err.println("=========================");
    }

    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProduct.getFactory("SHAPE");
        AbstractFactory colorFactory = FactoryProduct.getFactory("COLOR");

        Shape shape1 = shapeFactory.getShape("Circle");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("Square");
        shape2.draw();

        System.out.println("=========================");

        Color color1 = colorFactory.getColor("Red");
        color1.color();

        Color color2 = colorFactory.getColor("Blue");
        color2.color();

        System.out.println("=========================");
    }
}
