package com.eason.lottert.service;

import com.eason.lottert.bean.Order;

import java.util.List;

/**
 * @ 文件名:   OrderService
 * @ 创建者:   Eason
 * @ 时间:    2018/10/8 16:58
 * @ 描述:
 */
public interface OrderService {
    void save(Order order);

    List<Order> findOrder(String uid);
}
