package com.learning.java.basic.exception;

/*
 @author:   chenyang
 @date  2020/8/23 3:01 AM
 一：Exception分两种：
 1.checked Exception:
 可检查异常在 源代码里必须显式地进行捕获处理，这是编译期检查的一部分。
 2.unchecked Exception:
 不检查异常就是所谓的运行时异常，类似 NullPointerException、 ArrayIndexOutOfBoundsException 之类，
 通常是可以编码避免的逻辑错误，具体根据需 要来判断是否需要捕获，并不会在编译期强制要求。
 二.ClassNotFoundException和NoClassDefFoundError的区别
 1.ClassNotFoundException是checked Exception是这里没有显示的捕捉异常就会报红。这是checked Exception。
 2.NoClassDefFoundError
　 NoClassDefFoundError异常，看命名后缀是一个Error。从类继承层次上看，NoClassDefFoundError是从Error继承的。
   和ClassNotFoundException相比，明显的一个区别是，NoClassDefFoundError并不需要应用程序去关心catch的问题。
   场景：编译完后，把class删除会报NoClassDefFoundError这个错误。
*/

public class MainClass {

        public static void main(String[] args) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

}
