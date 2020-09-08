package com.learning.java.basic.finalizefinallyfinal;

/*
 @author:   chenyang

 try-with-resources 声明要求其中定义的变量实现 AutoCloseable 接口，
 这样系统可以自动调用它们的close方法，从而替代了finally中关闭资源的功能。
 try-with-resources其实是个语法糖，它将在编译时编译成关闭资源的代码。
 我们将上述例子中的代码编译成class文件，再反编译回java文件，就能看到如下代码
 @date  2020/9/6 12:11 AM

*/

import java.io.*;

public class TryWithResources {

    public static void main(String[] args) {

    }

    public static void copy(String src, String dst) {
        InputStream in = null;

        OutputStream out = null;
        try {
            in = new FileInputStream(src);
            out = new FileOutputStream(dst);
            byte[] buff = new byte[1024];
            int n;
            while ((n = in.read(buff)) >= 0) {
                out.write(buff, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //
    public static void copy1(String src, String dst) {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buff = new byte[1024];
            int n;
            while ((n = in.read(buff)) >= 0) {
                out.write(buff, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copy2(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buff = new byte[1024];
            int n;
            while ((n = in.read(buff)) >= 0) {
                out.write(buff, 0, n);
            }
        }
    }
}
