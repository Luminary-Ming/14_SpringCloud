package com.demo.controller;

import com.demo.pojo.Order;
import com.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * 使用 RestTemplate 类来实现服务调用
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable("id") Long id) {
        Order order = new Order();
        order.setOrderId(id.toString());
        order.setCreateTime(new Date());
        order.setStatus(1);
        // 远程调用 user-server 服务，获取用户信息
//      User user = restTemplate.getForEntity("http://127.0.0.1:9000/user/" + id, User.class).getBody();
        User user = restTemplate.getForObject("http://127.0.0.1:9000/user/" + id, User.class);
        order.setUser(user);
        return order;
    }
}
