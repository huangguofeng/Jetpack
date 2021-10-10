package com.hgf.jetpack.ui.fragment.data;

/**
 * A generic class that holds a result success w/ data or an error exception.
 */

/**
 * @author :huangguofeng
 * date    :2020/7/3
 * package :com.hgf.jetpack.ui.fragment.data
 * desc    :结果类
 */
public class Result<T> {
    // hide the private constructor to limit subclass types (Success, Error)
    private Result() {
    }

    @Override
    public String toString() {
        if (this instanceof Result.Success) {
            Result.Success success = (Result.Success) this;
            return "Success[data=" + success.getData().toString() + "]";
        } else if (this instanceof Result.Error) {
            Result.Error error = (Result.Error) this;
            return "Error[exception=" + error.getError().toString() + "]";
        }
        return "";
    }

    /**
     * 成功的结果
     */
    public final static class Success<T> extends Result {
        private T data;

        public Success(T data) {
            this.data = data;
        }

        public T getData() {
            return this.data;
        }
    }

    /**
     * 失败的结果
     */
    public final static class Error extends Result {
        private Exception error;

        public Error(Exception error) {
            this.error = error;
        }

        public Exception getError() {
            return this.error;
        }
    }
}