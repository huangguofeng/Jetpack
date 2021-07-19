package com.lib.java.observer;

/**
 * @author :huangguofeng
 * date    :2021/7/19
 * package :com.lib.java.observer
 * desc    :
 */
public class Player2 extends Observer {
    public Player2(Game g) {
        game = g;
        game.add(this);
    }

    @Override
    public void update() {
        System.out.println(" Player2 : 收到游戏消息 " + game.getState());
    }
}
