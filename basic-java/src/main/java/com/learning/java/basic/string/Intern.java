package com.learning.java.basic.string;

/*
 @author:   chenyang
 @date  2020/9/10 10:13 AM

  When the intern method is invoked, if the pool already contains a
     * string equal to this {@code String} object as determined by
     * the {@link #equals(Object)} method, then the string from the pool is
     * returned. Otherwise, this {@code String} object is added to the
     * pool and a reference to this {@code String} object is returned.
     如果调用该方法，如果常量池中包含了一个和当前对象相等的字符串则返回常量池中的字符串，
     否则把改字符串放到常量池中，并返回字符串的引用到这个字符串变量。

     new String("abcd")无法把"abcd"放入常量池。
     放入常量池的方法：
     1.  String string=new String("abcd");
         String aaa=string.intern();
     2.  String string="abcd";
*/

public class Intern {
    public  static void main(String [] args){
        String string=new String("abcd")+new String("efg");  //  在堆中产生三个对象，string只指向合并后生成的那个"abcdefg"对象；
        String str2="abcdefg";		//  在常量池中找，没有“abcdefg”，所以生成一个此常量对象，str2指向此对象
        String aaa=string.intern();					//  在常量池中找，已经存在“abcdefg”这个常量对象，故不生成引用
        System.out.println(string==str2);    // >>>>>>>> false  //  两个对象的地址不一样，故false

        String string1=new String("he")+new String("llo"); //   在堆中产生三个对象，string只指向合并后生成的那个"hello"对象；
        String bbb=string1.intern();					//   在常量池中找，没有“hello”这个常量对象，所以生成常量引用，和堆中那个对象的地址相同
        String str21="hello";			//  常量池中已经存在这个常量对象的引用，所以str2指向这个引用，所以str2也指向string对象
        System.out.println(string1==str21);    // >>>>>>>>   地址一样，内容一样，所以true
    }
}
