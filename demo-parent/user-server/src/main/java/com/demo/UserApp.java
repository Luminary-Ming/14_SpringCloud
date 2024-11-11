package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
// 开启服务发现功能，服务发现机制能够将微服务启动时注册到服务注册中心（Nacos），这样可以通过服务名来调用
// 导入 spring-cloud-starter-alibaba-nacos-discovery 依赖后可以省略
// @EnableDiscoveryClient
public class UserApp {
    public static void main(String[] args) {
        SpringApplication.run(UserApp.class, args);
    }
}
