package com.lib.java.proxy;

/**
 * @author :huangguofeng
 * date    :2021/7/19
 * package :com.lib.java.proxy
 * desc    :静态代理类 处理一些被代理类以外的事，真正的核心还是需要被代理人自己处理
 */
public class HouseProxy implements House {
    private HouseOwner house;

    public HouseProxy() {
        house = new HouseOwner();
    }

    @Override
    public void sale() {
        beforeSaleHouse();
        house.sale();
        afterSaleHouse();
    }

    @Override
    public int getMoney(int number) {
        return house.getMoney(number);
    }

    private void beforeSaleHouse() {
        System.out.println(" 房屋代理 卖房前和客户沟通");
    }

    private void afterSaleHouse() {
        System.out.println(" 房屋代理 在卖子卖出后和客户吃饭");
    }
}
