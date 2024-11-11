package com.demo.controller;

import com.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        System.out.println("EEEE");
        User user = new User();
        user.setId(id);
        user.setUsername("亚索EEEE");
        user.setAge(100);
        user.setEmail("Yasuo@qq.com");
        user.setPassword("123456");
        return user;
    }

    @GetMapping("/all")
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i + 1);
            user.setUsername("亚索" + i);
            user.setAge(50 + i);
            user.setEmail("Yasuo" + i + "@qq.com");
            user.setPassword("123456");
            users.add(user);
        }
        return users;
    }
}
