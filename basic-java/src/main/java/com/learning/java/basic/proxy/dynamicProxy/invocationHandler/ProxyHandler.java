package com.learning.java.basic.proxy.dynamicProxy.invocationHandler;

import com.learning.java.basic.proxy.staticProxy.Hello;
import com.learning.java.basic.proxy.staticProxy.HelloInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/*
动态代理具体步骤：

1.通过实现 InvocationHandler 接口创建自己的调用处理器；
2.通过为 Proxy 类指定 ClassLoader 对象和一组 interface 来创建动态代理类；
3.通过反射机制获得动态代理类的构造函数，其唯一参数类型是调用处理器接口类型；
4.通过构造函数创建动态代理类实例，构造时调用处理器对象作为参数被传入。


public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h)
        throws IllegalArgumentException
    {
        // 检查空指针
        Objects.requireNonNull(h);
        // 用原型实例指定创建对象的种类,并且通过拷贝这些原型创建新的对象
        final Class<?>[] intfs = interfaces.clone();
        // 获取系统的安全接口,不为空的话需要验证是否允许访问这种关系的代理访问
        final SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            checkProxyAccess(Reflection.getCallerClass(), loader, intfs);
        }
        // 生成代理类 Class,通过类加载器和接口
         Class<?> cl = getProxyClass0(loader, intfs);


       //通过构造器来创建实例

                try {
                if (sm != null) {
                checkNewProxyPermission(Reflection.getCallerClass(), cl);
                }
        //获取所有的构造器
        final Constructor<?> cons = cl.getConstructor(constructorParams);
        final InvocationHandler ih = h;
        // 构造器不是public的话需要设置可以访问
        if (!Modifier.isPublic(cl.getModifiers())) {
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
public Void run() {
        cons.setAccessible(true);
        return null;
        }
        });
        }
        // 返回创建的代理类Class的实例对象
        return cons.newInstance(new Object[]{h});
        } catch (IllegalAccessException|InstantiationException e) {
        throw new InternalError(e.toString(), e);
        } catch (InvocationTargetException e) {
        Throwable t = e.getCause();
        if (t instanceof RuntimeException) {
        throw (RuntimeException) t;
        } else {
        throw new InternalError(t.toString(), t);
        }
        } catch (NoSuchMethodException e) {
        throw new InternalError(e.toString(), e);
        }
        }

 */
public class ProxyHandler implements InvocationHandler {
    private Object object;
    public ProxyHandler(Object object){
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke "  + method.getName());
        method.invoke(object, args);
        System.out.println("After invoke " + method.getName());
        return null;
    }

    public static void main(String[] args) {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        HelloInterface hello = new Hello();
        ByeInterface bye = new Bye();

        InvocationHandler handler = new ProxyHandler(hello);
        InvocationHandler handler1 = new ProxyHandler(bye);

        HelloInterface proxyHello = (HelloInterface) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), handler);
        ByeInterface proxyBye = (ByeInterface) Proxy.newProxyInstance(bye.getClass().getClassLoader(), bye.getClass().getInterfaces(), handler1);

        proxyHello.sayHello();
        proxyBye.sayBye();
        proxyBye.sayGood();
    }
}