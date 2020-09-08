package com.learning.java.basic.exception;

/*
 @author:   chenyang
 @date  2020/8/25 8:02 PM

以下程序的问题设计两个异常处理原则：
1.第一，尽量不要捕获类似 Exception 这样的通用异常，而是应该捕获特定异常，
  在这里是 Thread.sleep() 抛出的 InterruptedException。
2.第二，不要生吞(swallow)异常（catch里什么都没做，最少要写上日志）。这是异常处理中要特别注意的事情，因为很可能会导 致非常难以诊断的诡异情况。

*/

public class ExceptionPrinciple {

    public static void main(String[] args) {
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            //什么都没做
        }
    }


}
