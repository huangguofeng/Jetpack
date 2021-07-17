package com.lib.java.factory;

/**
 * @author :huangguofeng
 * date    :2021/7/17
 * package :com.lib.java.factory
 * desc    :抽象工厂，用于产出工厂
 */
public abstract class AbstractFactory {
    /**
     * 获取形状
     *
     * @param type 类型
     * @return Shape
     */
    abstract Shape getShape(String type);

    /**
     * 获取颜色
     *
     * @param type 类型
     * @return Color
     */
    abstract Color getColor(String type);
}
