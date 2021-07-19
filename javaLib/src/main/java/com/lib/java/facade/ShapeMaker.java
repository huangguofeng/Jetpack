package com.lib.java.facade;

/**
 * @author :huangguofeng
 * date    :2021/7/19
 * package :com.lib.java.facade
 * desc    :
 */
public class ShapeMaker {
    private Shape circle;
    private Shape rectangle;

    public ShapeMaker() {
        circle = new Circle();
        rectangle = new Rectangle();
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawRectangle() {
        rectangle.draw();
    }
}
