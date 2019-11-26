package com.lupf.javaproxy.proxy.static_proxy;

public class Proxy implements Subject {
    private Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        System.out.println("代码执行前增强！");
        try {
            subject.request();
            System.out.println("代码执行后增强！");
        } catch (Exception e) {
            System.out.println("代码执行异常！");
            // 由于这里只是代理，所以对异常处理完之后，还需要将其再抛出去
            throw e;
        }
        System.out.println("代码执行完！");
    }
}
