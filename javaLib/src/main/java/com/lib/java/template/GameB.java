package com.lib.java.template;

/**
 * @author :huangguofeng
 * date    :2021/7/20
 * package :com.lib.java.template
 * desc    :子模板B
 */
public class GameB extends Game {

    @Override
    void endPlay() {
        System.out.println("游戏B结束了");
    }

    @Override
    void initialize() {
        System.out.println("游戏B初始化了");
    }

    @Override
    void startPlay() {
        System.out.println("游戏B开始游戏");
    }
}
