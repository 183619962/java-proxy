package com.lupf.javaproxy.proxy.cglib_proxy.abs;

import net.sf.cglib.core.DebuggingClassWriter;

public class test {
    public static void main(String[] args) {
        //将生成的代理对象输出到指定的路径
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E://logs");
        //目标对象
        RealSubject realSubject = new RealSubject();
        //生成代理对象
        RealSubject proxyObj = (RealSubject) new ProxyFactory(realSubject).getProxyInstrance();
        //调用方法
        proxyObj.request();
    }
}
