package com.example.androidbase.thread;

/**
 * @author :huangguofeng
 * date    :2021/8/6
 * package :com.example.androidbase.thread
 * desc    :
 */
public class MessageWrap {
    public final String message;

    public static MessageWrap getInstance(String message) {
        return new MessageWrap(message);
    }

    private MessageWrap(String message) {
        this.message = message;
    }
}
