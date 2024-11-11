package com.demo.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 订单类
 */
@Data
public class Order {
    // 订单ID
    private String orderId;
    // 订单生成时间
    private Date createTime;
    // 订单状态
    private Integer status;

    // 订单对应的用户
    private User user;
}
