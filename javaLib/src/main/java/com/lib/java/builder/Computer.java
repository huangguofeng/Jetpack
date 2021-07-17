package com.lib.java.builder;

/**
 * @author :huangguofeng
 * date    :2021/7/17
 * package :com.lib.java.builder
 * desc    :建造者模式,简化模式
 */
public class Computer {
    private String name = null;
    private String type = null;
    private String size = null;
    private String price = null;
    private String make = null;

    private Computer(Builder builder){
        this.name = builder.name;
        this.type = builder.type;
        this.size = builder.size;
        this.price = builder.price;
        this.make = builder.make;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", price='" + price + '\'' +
                ", make='" + make + '\'' +
                '}';
    }

    public static class Builder{
        private String name;
        private String type;
        private String size;
        private String price;
        private String make;

        public Builder setName(String n){
            name = n;
            return this;
        }

        public Builder setType(String t){
            type = t;
            return this;
        }

        public Builder setSize(String s){
            size = s;
            return this;
        }

        public Builder setPrice(String p){
            price = p;
            return this;
        }

        public Builder setMake(String m){
            make = m;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }
    }
}
