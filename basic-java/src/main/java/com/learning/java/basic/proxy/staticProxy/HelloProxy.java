package com.learning.java.basic.proxy.staticProxy;

/*
静态代理:
创建一个接口，然后创建被代理的类实现该接口并且实现该接口中的抽象方法。之后再创建一个代理类，同时使其也实现这个接口。
在代理类中持有一个被代理对象的引用，而后在代理类方法中调用该对象的方法。

使用静态代理很容易就完成了对一个类的代理操作。但是静态代理的缺点也暴露了出来：
由于代理只能为一个类服务，如果需要代理的类很多，那么就需要编写大量的代理类，比较繁琐。
 */

public class HelloProxy implements HelloInterface{
    private HelloInterface helloInterface = new Hello();
    @Override
    public void sayHello() {
        System.out.println("Before invoke sayHello" );
        helloInterface.sayHello();
        System.out.println("After invoke sayHello");
    }

    public static void main(String[] args) {
        HelloProxy helloProxy = new HelloProxy();
        helloProxy.sayHello();
    }
}