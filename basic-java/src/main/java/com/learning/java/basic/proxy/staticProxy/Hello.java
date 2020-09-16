package com.learning.java.basic.proxy.staticProxy;

public class Hello implements HelloInterface{
    @Override
    public void sayHello() {
        System.out.println("Hello zhanghao!");
    }
}