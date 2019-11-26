package com.lupf.javaproxy.proxy.cglib_proxy.abs;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstrance() {
        //实例化Enhancer对象
        Enhancer enhancer = new Enhancer();
        //设置代理类拦截器 this指当前的Interceptor
        enhancer.setCallback(this);
        //设置当前的目标类为父类
        enhancer.setSuperclass(target.getClass());
        //设置实现的接口 获取传入进来的对象的接口类
        //enhancer.setInterfaces(target.getClass().getInterfaces());
        //返回创建的对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
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
