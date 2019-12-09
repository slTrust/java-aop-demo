package com.aop.demo;

import java.util.UUID;

public class DataServiceImpl implements DataService {
    public String a(int i) {
        return UUID.randomUUID().toString();
    }

    public String b(int i) {
        return UUID.randomUUID().toString();
    }
}
