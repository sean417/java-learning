package com.learning.java.basic.exception;

/*
 @author:   chenyang
 @date  2020/8/25 8:17 PM
“throw early": 让异常尽早暴露出来。
"catch late”，其实是我们经常苦恼的问题，捕获异常后，需要怎么处理呢?最差的 处理方式，就是我前面提到的“生吞异常”，
本质上其实是掩盖问题。如果实在不知道如何 处理，可以选择保留原有异常的 cause 信息，直接再抛出或者构建新的异常抛出去。
在更 高层面，因为有了清晰的(业务)逻辑，往往会更清楚合适的处理方式是什么.

*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Objects;

public class ThrowEarlyCatchLate {

    public void readPreferences(String filename) throws FileNotFoundException{
        //“throw early"让null尽早暴露出来
        Objects.requireNonNull(filename);
        //"catch late"
        InputStream in = new FileInputStream(filename);
}

}
