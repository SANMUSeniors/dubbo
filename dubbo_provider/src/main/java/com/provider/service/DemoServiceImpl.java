package com.provider.service;

import com.api.service.DemoService;

public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        return "Hello "+name;
    }
}
