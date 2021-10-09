package com.example.myapplication.bean;

public enum ResultCode {

    SUCCESS(0),
    FAIL(-1);

    ResultCode(int c){
        code = c;
    }

    int code;

    public void setCode(int code) {
        this.code = code;
    }

    public int value(){
        return code;
    }
}
