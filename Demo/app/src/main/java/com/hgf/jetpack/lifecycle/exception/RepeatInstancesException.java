package com.hgf.jetpack.lifecycle.exception;

import com.hgf.jetpack.utils.ILog;

/**
 * @author :huangguofeng
 * date    :2020/7/1
 * package :com.hgf.jetpack.lifecycle.exception
 * desc    :
 */
public class RepeatInstancesException extends Exception {
    public RepeatInstancesException() {

    }

    public RepeatInstancesException(String msg) {
        ILog.lofVerbose(msg);
    }
}
