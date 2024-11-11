package com.demo.controller;

import com.demo.feign.UserOpenFeignClient;
import com.demo.pojo.Order;
import com.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 使用 OpenFeign 来实现服务调用
 */
@RestController
@RequestMapping("/order2")
// 项目启动后，在Nacos中修改服务的配置文件后，可以保证配置文件动态刷新
@RefreshScope
public class OrderController2 {
    @Value("${lol.username}")
    private String username;
    @Value("${lol.age}")
    private Integer age;
    @Value("${lol.address}")
    private String address;
    @Autowired
    private UserOpenFeignClient userOpenFeignClient;

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable("id") Long id) {
        System.out.println(username);
        System.out.println(age);
        System.out.println(address);
        Order order = new Order();
        order.setOrderId(id.toString());
        order.setCreateTime(new Date());
        order.setStatus(1);
        // 使用OpenFeign实现对user-server服务的调用
        User user = userOpenFeignClient.getUserById(id);
        order.setUser(user);
        return order;
    }
}
