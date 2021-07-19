package com.lib.java.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :huangguofeng
 * date    :2021/7/19
 * package :com.lib.java.iterator
 * desc    :迭代器模式：提供一种方法顺序访问一个聚合对象中各个元素, 而又无须暴露该对象的内部表示
 * 1：声明迭代器接口A 两个方法分别用于判断是否有下一个元素和获取下一个元素对象
 * 2：声明获取迭代器接口对象的接口B,接口方法返回迭代器接口对象
 * 3：目标类实现B接口,接口方法返回内部类C的对象实例，内部类自定义类C实现A，C内部实现的接口方法中针对B中的数组集合等元素进行遍历的准备
 */
public class IteratorDemo {
    public static void main(String[] args) {
        Name n = new Name();

        for (Iterator iter = n.getIterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        }
        java.util.Iterator iterator;
        List list = new ArrayList();
    }
}
