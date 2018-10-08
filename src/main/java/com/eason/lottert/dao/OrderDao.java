package com.eason.lottert.dao;

import com.eason.lottert.bean.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ 文件名:   OrderDao
 * @ 创建者:   Eason
 * @ 时间:    2018/10/8 17:02
 * @ 描述:
 */
public interface OrderDao extends JpaRepository<Order, String> {
    List<Order> findByUid(String uid);
}
