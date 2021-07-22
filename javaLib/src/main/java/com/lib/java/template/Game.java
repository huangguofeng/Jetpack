package com.lib.java.template;

/**
 * @author :huangguofeng
 * date    :2021/7/20
 * package :com.lib.java.template
 * desc    :抽象类，设定模板方法为final
 */
public abstract class Game {
    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();

    //模板
    public final void play() {

        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }
}
