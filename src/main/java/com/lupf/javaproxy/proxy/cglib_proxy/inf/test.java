package com.lupf.javaproxy.proxy.cglib_proxy.inf;

import net.sf.cglib.core.DebuggingClassWriter;

public class test {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E://logs");
        // 目标对象
        Subject realSubject = new RealSubject();
        // 代理对象
        Subject proxyObj = (Subject) new ProxyFactory(realSubject).getProxyInstrance();
        // 方法调用
        proxyObj.request();
    }
}
