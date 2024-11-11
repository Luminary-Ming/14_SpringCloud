package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
// 开启OpenFeign的远程调用功能
@EnableFeignClients
public class OrderApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class, args);
    }

    /*
        配置 RestTemplate 类的对象，交给 Spring 管理
        RestTemplate是Spring框架提供的一个用于访问RESTful服务的客户端工具。它封装了常见的HTTP请求操作，简化了与RESTful服务的交互过程
            ● getForEntity：发送一个HTTP GET请求，并返回ResponseEntity对象，该对象包含了响应体、响应头、响应状态等信息
            ● getForObject：发送一个HTTP GET请求，并将响应体映射为指定的Java对象
            ● postForEntity：发送一个HTTP POST请求，并返回ResponseEntity对象
            ● postForObject：发送一个HTTP POST请求，并返回根据响应体匹配形成的对象
     */
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
