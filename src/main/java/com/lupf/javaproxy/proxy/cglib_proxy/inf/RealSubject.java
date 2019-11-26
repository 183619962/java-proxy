package com.lupf.javaproxy.proxy.cglib_proxy.inf;

import org.springframework.validation.annotation.Validated;

public class RealSubject implements Subject {
    @Validated
    public void request() {
        System.out.println("我是 RealSubject");
    }
}
