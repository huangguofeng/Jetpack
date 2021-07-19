package com.lib.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author :huangguofeng
 * date    :2021/7/19
 * package :com.lib.java.proxy
 * desc    :代理模式
 * 静态代理：代理类和被代理类实现同一个接口，代理类持有被代理类的对象，在接口方法中使用被代理类对象掉用接口方法
 * 动态代理：使用Proxy.newProxyInstance动态的在运行时生成一个代理类，通过反射的方式，
 * 注意修改InvocationHandler中invoke方法返回值，不可以默认null，不然目标接口有带返回值的方法将会空指针异常
 */
public class ProxyDemo {
    public static void main(String[] args) {
//        HouseProxy proxy = new HouseProxy();
//        proxy.sale();
//        int number = proxy.getMoney(1000);
//        System.out.println(number);
        main2(args);
    }

    private static void main2(String[] args) {
        final HouseOwner houseOwner = new HouseOwner();

        House house = (House) Proxy.newProxyInstance(houseOwner.getClass().getClassLoader(), houseOwner.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("代理前");
                Object result = method.invoke(houseOwner, args);
                System.out.println(result);
                System.out.println("代理后");
                return result;
            }
        });
        house.sale();
        int n = house.getMoney(1000);
        System.out.println("测试：" + n);
    }


}
