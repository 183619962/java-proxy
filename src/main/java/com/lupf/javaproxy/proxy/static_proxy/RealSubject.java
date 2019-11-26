package com.lupf.javaproxy.proxy.static_proxy;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("我是 RealSubject");
    }
}
