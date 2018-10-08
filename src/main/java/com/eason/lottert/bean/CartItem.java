package com.eason.lottert.bean;

import lombok.Data;

/**
 * @ 文件名:   CartItem
 * @ 创建者:   Eason
 * @ 时间:    2018/10/7 0:51
 * @ 描述:
 */
@Data
public class CartItem {
    //红球
    private String red;
    //蓝球
    private String blue;
    //数量
    private int count = 1;
    //单价
    private double price = 2;
    //小计
    private double subtotal;

    public double getSubtotal() {
        return count * price;
    }
}
