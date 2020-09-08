package com.learning.java.basic.finalizefinallyfinal;

/*
 @author:   chenyang
 @date  2020/9/7 12:10 AM
1. 注意，final 不是 immutable!
final 只能约束 strList 这个引用不可以被赋值，但是 strList 对象行为不被 final 影响，
添加 元素等操作是完全正常的。如果我们真的希望对象本身是不可变的，那么需要相应的类支持 不可变的行为。
2.用Collections.unmodifiableList可以实现unmodifiable的集合
3.Immutable 在很多场景是非常棒的选择，某种意义上说，Java 语言目前并没有原生的不可 变支持，如果要实现 immutable 的类，我们需要做到:
将 class 自身声明为 final，这样别人就不能扩展来绕过限制了。 将所有成员变量定义为 private 和 final，并且不要实现 setter 方法。
 通常构造对象时，成员变量使用深度拷贝来初始化，而不是直接赋值，这是一种防御措
 施，因为你无法确定输入对象不被其他人修改。
如果确实需要实现 getter 方法，或者其他可能会返回内部状态的方法，使用 copy-on- write 原则，创建私有的 copy。
*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ImmutableVariable {

    public static void main(String[] args) {
        final List<String> strList = new ArrayList<>();
        strList.add("Hello");
        strList.add("world");
        List<String> fruitsList = new ArrayList<String>(Arrays.asList("Apple", "Orange"));
        List<String> fruitsUnmodifiableList = Collections.unmodifiableList(fruitsList);
        fruitsUnmodifiableList.add("Pear");

    }


}
