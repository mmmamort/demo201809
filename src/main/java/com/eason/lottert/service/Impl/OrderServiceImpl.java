package com.eason.lottert.service.Impl;

import com.eason.lottert.bean.Order;
import com.eason.lottert.dao.OrderDao;
import com.eason.lottert.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ 文件名:   OrderServiceImpl
 * @ 创建者:   Eason
 * @ 时间:    2018/10/8 17:01
 * @ 描述:
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public void save(Order order) {
        orderDao.save(order);
    }

    @Override
    public List<Order> findOrder(String uid) {
        return orderDao.findByUid(uid);
    }
}
