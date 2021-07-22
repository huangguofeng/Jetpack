package com.lib.java.template;

/**
 * @author :huangguofeng
 * date    :2021/7/20
 * package :com.lib.java.template
 * desc    :子模板A
 */
public class GameA extends Game {

    @Override
    void endPlay() {
        System.out.println("游戏A结束了 奖励一块钱!");
    }

    @Override
    void initialize() {
        System.out.println("游戏A初始化了");
    }

    @Override
    void startPlay() {
        System.out.println("游戏A开始游戏");
    }
}
