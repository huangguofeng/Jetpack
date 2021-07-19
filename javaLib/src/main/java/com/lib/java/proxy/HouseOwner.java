package com.lib.java.proxy;

/**
 * @author :huangguofeng
 * date    :2021/7/19
 * package :com.lib.java.proxy
 * desc    :被代理人 真正要做的无法被代理的事
 */
public class HouseOwner implements House {
    @Override
    public void sale() {
        System.out.println(" 房东签合同卖了房子 ");
    }

    @Override
    public int getMoney(int number) {
        System.out.println(" 房东房子卖了 " + number + " 万");
        return number;
    }
}
