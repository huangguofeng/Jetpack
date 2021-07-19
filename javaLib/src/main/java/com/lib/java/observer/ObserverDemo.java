package com.lib.java.observer;

/**
 * @author :huangguofeng
 * date    :2021/7/19
 * package :com.lib.java.observer
 * desc    :观察者模式：当对象间存在一对多关系时，则使用观察者模式（Observer Pattern）。比如，当一个对象被修改时，则会自动通知依赖它的对象
 */
public class ObserverDemo {


    public static void main(String[] args) {
        Game game = new Game();
        Player1 player1 = new Player1(game);
        Player2 player2 = new Player2(game);

        game.setState(1);
        System.out.println(" ");
        game.setState(2);
    }
}
