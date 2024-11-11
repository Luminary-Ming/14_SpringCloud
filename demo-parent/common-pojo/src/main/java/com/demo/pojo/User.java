package com.demo.pojo;

import lombok.Data;

/**
 * 用户类
 */
@Data
public class User {
    // 用户ID
    private Integer Id;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 邮箱
    private String email;
    // 年龄
    private Integer age;
}
