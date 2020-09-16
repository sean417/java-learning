package com.learning.java.basic.proxy.dynamicProxy.Cglib;

/*
 @author:   chenyang
 @date  2020/9/16 2:54 AM

*/

public class Main {

    public static void main(String[] args) {
        CglibInterceptor cglibProxy = new CglibInterceptor();
        CglibHelloClass cglibHelloClass = (CglibHelloClass) cglibProxy.newProxyInstance(CglibHelloClass.class);
        cglibHelloClass.sayHello("isole");
        cglibHelloClass.sayByeBye("sss");
    }
}
