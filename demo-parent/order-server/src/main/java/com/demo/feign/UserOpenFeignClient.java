package com.demo.feign;

import com.demo.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/*
    该接口是声明一个Feign客户端，以便调用远程服务。
    @FeignClient注解允许开发者以声明式的方式定义和调用远程服务的RESTful接口。
    通过该注解，开发者只需定义一个Java接口，并使用Spring MVC的注解（如@GetMapping、@PostMapping等）来配置请求的URL、方法、参数等。
    Feign会自动为这个接口生成一个实现类，该实现类会处理HTTP请求的发送和响应的接收。
    name：被调用的服务名称
    path：指定服务中的URL路径
 */
@FeignClient(name = "user-server", path = "/user")
public interface UserOpenFeignClient {
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id);

    @GetMapping("/all")
    public List<User> getAllUser();
}
