package com.learning.java.basic.proxy.dynamicProxy.Cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
* CglibInterceptor 用于对方法调用拦截以及回调
 *
 * CGLIB 动态代理基于 ASM 框架通过生成业务类的子类来实现。

 JDK 动态代理的优势是最小化依赖关系，减少依赖意味着简化开发和维护并且有 JDK 自身支持。还可以平滑进行 JDK 版本升级，代码实现简单。基于 CGLIB 框架的优势是无须实现接口，达到代理类无侵入，我们只需操作我们关系的类，不必为其它相关类增加工作量，性能比较高。

 描述代理的几种实现方式? 分别说出优缺点?

 代理可以分为 "静态代理" 和 "动态代理"，动态代理又分为 "JDK 动态代理" 和 "CGLIB 动态代理" 实现。

 静态代理：代理对象和实际对象都继承了同一个接口，在代理对象中指向的是实际对象的实例，这样对外暴露的是代理对象而真正调用的是 Real Object.

 优点：可以很好的保护实际对象的业务逻辑对外暴露，从而提高安全性。*

 缺点：不同的接口要有不同的代理类实现，会很冗余

 JDK 动态代理：
 为了解决静态代理中，生成大量的代理类造成的冗余；
 JDK 动态代理只需要实现 InvocationHandler 接口，重写 invoke 方法便可以完成代理的实现，

 jdk 的代理是利用反射生成代理类 Proxyxx.class 代理类字节码，并生成对象
 jdk 动态代理之所以只能代理接口是因为代理类本身已经 extends 了 Proxy，而 java 是不允许多重继承的，但是允许实现多个接口

 优点：解决了静态代理中冗余的代理实现类问题。

 缺点：JDK 动态代理是基于接口设计实现的，如果没有接口，会抛异常。

 CGLIB 代理：
 由于 JDK 动态代理限制了只能基于接口设计，而对于没有接口的情况，JDK 方式解决不了；
 CGLib 采用了非常底层的字节码技术，其原理是通过字节码技术为一个类创建子类，并在子类中采用方法拦截的技术拦截所有父类方法的调用，顺势织入横切逻辑，来完成动态代理的实现。
 实现方式实现 MethodInterceptor 接口，重写 intercept 方法，通过 Enhancer 类的回调方法来实现。

 但是 CGLib 在创建代理对象时所花费的时间却比 JDK 多得多，所以对于单例的对象，因为无需频繁创建对象，用 CGLib 合适，反之，使用 JDK 方式要更为合适一些。
 同时，由于 CGLib 由于是采用动态创建子类的方法，对于 final 方法，无法进行代理。

 优点：没有接口也能实现动态代理，而且采用字节码增强技术，性能也不错。
 缺点：技术实现相对难理解些。
*
*/
public class CglibInterceptor implements MethodInterceptor {
   /**
    * CGLIB 增强类对象，代理类对象是由 Enhancer 类创建的，
    * Enhancer 是 CGLIB 的字节码增强器，可以很方便的对类进行拓展
    */
   private Enhancer enhancer = new Enhancer();

   /**
    *
    * @param obj  被代理的对象
    * @param method 代理的方法
    * @param args 方法的参数
    * @param proxy CGLIB方法代理对象
    * @return  cglib生成用来代替Method对象的一个对象，使用MethodProxy比调用JDK自身的Method直接执行方法效率会有提升
    * @throws Throwable
    */
   @Override
   public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
       System.out.println("这里是对目标类进行增强！！！");
       System.out.println("方法调用之前");
       Object o = proxy.invokeSuper(obj, args);
       System.out.println("方法调用之后");
       return o;
   }


   /**
    * 使用动态代理创建一个代理对象
    * @param c
    * @return
    */
   public  Object newProxyInstance(Class<?> c) {
       /**
        * 设置产生的代理对象的父类,增强类型
        */
       enhancer.setSuperclass(c);
       /**
        * 定义代理逻辑对象为当前对象，要求当前对象实现 MethodInterceptor 接口
        */
       enhancer.setCallback(this);
       /**
        * 使用默认无参数的构造函数创建目标对象,这是一个前提,被代理的类要提供无参构造方法
        */
       return enhancer.create();
   }
}