package com.learning.java.basic.proxy.dynamicProxy.invocationHandler;

public class Bye implements ByeInterface {
    @Override
    public void sayBye() {
        System.out.println("say bye!");
    }

    @Override
    public void sayGood() {
        System.out.println("say good!");
    }
}