package com.aop.demo;

import java.util.UUID;

public class DataServiceImpl2 {
    public String a(int i) {
        return UUID.randomUUID().toString();
    }

    public String b(int i) {
        return UUID.randomUUID().toString();
    }
}
