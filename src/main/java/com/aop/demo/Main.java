package com.aop.demo;

import net.sf.cglib.proxy.Enhancer;
import java.lang.reflect.Proxy;

public class Main {
    static DataService service = new LogDecorator(new DataServiceImpl());

    // AOP动态代理
    static DataService service2 = new DataServiceImpl();

    public static void main(String[] args) {
        // OOP装饰器模式
        System.out.println(service.a(1));
        System.out.println(service.b(1));

        System.out.println("动态代理-----------------");
        // 动态代理
        DataService dataService = (DataService) Proxy.newProxyInstance(service2.getClass().getClassLoader(), //  接口实现类
                            new Class[]{DataService.class}, // 代理类(必须是接口否则报错)
                            new LogProxy(service2) // 这个方法拦截后被谁处理
                            );

        dataService.a(1);
        dataService.b(2);

        // AOP 动态字节码
        System.out.println("动态字节码-----------------");
        // 动态字节码增强
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(DataServiceImpl2.class);// 设置超类
        enhancer.setCallback(new LogInterceptor(new DataServiceImpl2())); // 设置回调

        // 使用动态字节码增强过的
        DataServiceImpl2 enhancedService = (DataServiceImpl2) enhancer.create();
        enhancedService.a(1);
        enhancedService.b(2);
    }
}
