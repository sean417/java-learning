package com.learning.java.basic.finalizefinallyfinal;

/*
 @author:   chenyang
 @date  2020/9/8 10:29 PM
1. finalize 被设计成在对象被垃圾收集前调用，这就意味着实现了 finalize 方法的对象
是个“特殊公民”，JVM 要对它进行额外处理。finalize 本质上成为了快速回收的阻碍 者，
可能导致你的对象经过多个垃圾收集周期才能被回收。
2.finalize 的执行是和垃圾收集关联在一起的，一旦实现了非空的 finalize 方法，
就会导致相 应对象回收呈现数量级上的变慢，有人专门做过 benchmark，大概是 40~50 倍的下降。

*/

public class Finalizer {


}
