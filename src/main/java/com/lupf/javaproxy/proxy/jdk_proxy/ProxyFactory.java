package com.lupf.javaproxy.proxy.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory implements InvocationHandler {
    //真实的目标对象
    private Object target;

    /**
     * @param target 真实的目标对象
     */
    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstrance() {
        // 三个参数
        // 第一个：目标对象的类加载器  通过object.getClass().getClassLoader() 获取
        // 第二个：目标对象实现的接口
        // 第三个：事件处理，执行目标对象的方法时，会触发事件处理器方法(也就是InvocationHandler中的invoke)
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代码执行前增强！");
        Object returnObj;
        try {
            // 执行真实的目标对象的方法
            returnObj = method.invoke(target, args);
            System.out.println("代码执行后增强！");
        } catch (Exception e) {
            System.out.println("代码执行异常！");
            // 由于这里只是代理，所以对异常处理完之后，还需要将其再抛出去
            throw e;
        }
        System.out.println("代码执行完！");
        return returnObj;
    }
}
