package com.lupf.javaproxy.proxy.jdk_proxy;

public class test {
    public static void main(String[] args) {
        // 设置参数，将生成的代理对象以文件的形式输出到com.sun.proxy.$Proxy0.class
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        // 生成目标对象
        Subject target = new RealSubject();
        //通过ProxyFactory生成代理对象
        Subject proxyObj = (Subject) new ProxyFactory(target).getProxyInstrance();
        //调用方法
        proxyObj.request();
    }
}
