package com.lib.java.factory;

/**
 * @author :huangguofeng
 * date    :2021/7/17
 * package :com.lib.java.factory
 * desc    :工厂用于产出目标对象，只需要知道其名字就能输出对象
 * 优点： 1、一个调用者想创建一个对象，只要知道其名称就可以了。 2、扩展性高，如果想增加一个产品，只要扩展一个工厂类就可以。 3、屏蔽产品的具体实现，调用者只关心产品的接口。
 * 缺点：每次增加一个产品时，都需要增加一个具体类和对象实现工厂，使得系统中类的个数成倍增加，在一定程度上增加了系统的复杂度，同时也增加了系统具体类的依赖。这并不是什么好事。
 */
public class ShapeFactory extends AbstractFactory{
    @Override
    public Shape getShape(String type){
        if("Circle".equals(type)){
            return new Circle();
        }
        if("Square".equals(type)){
            return new Square();
        }
        return null;
    }

    @Override
    Color getColor(String type) {
        return null;
    }

}
