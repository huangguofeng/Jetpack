package com.lib.java.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :huangguofeng
 * date    :2021/7/19
 * package :com.lib.java.observer
 * desc    :
 */
public class Game {
    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void add(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
