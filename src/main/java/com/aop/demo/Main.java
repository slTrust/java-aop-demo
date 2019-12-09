package com.aop.demo;

import java.lang.reflect.Proxy;

public class Main {
    static DataService service = new LogDecorator(new DataServiceImpl());

    static DataService service2 = new DataServiceImpl();

    public static void main(String[] args) {
        // OOP装饰器模式
        System.out.println(service.a(1));
        System.out.println(service.b(1));

        // 动态代理
        DataService dataService = (DataService) Proxy.newProxyInstance(service2.getClass().getClassLoader(), //  接口实现类
                            new Class[]{DataService.class}, // 代理类(必须是接口否则报错)
                            new LogProxy(service2) // 这个方法拦截后被谁处理
                            );

        dataService.a(1);
        dataService.b(2);
    }
}
