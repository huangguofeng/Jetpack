package com.lib.java.factory;

/**
 * @author :huangguofeng
 * date    :2021/7/17
 * package :com.lib.java.factory
 * desc    :实际产出工厂的方式
 */
public class FactoryProduct {
    public static AbstractFactory getFactory(String type){
        if(type.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        } else if(type.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
}
