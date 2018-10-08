package com.eason.lottert.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @ 文件名:   OrderItem
 * @ 创建者:   Eason
 * @ 时间:    2018/10/8 16:19
 * @ 描述:
 */
@Data
@Entity
public class OrderItem {
    //0.订单项的编号
    @Id
    private String itemid;
    //1.购买的是哪一期
    private String code;
    //2.购买红球的号码
    private String red;
    //3.购买的蓝球号码
    private String blue;
    //4.购买的数量
    private int count;

    //5.小计
    private double subtotal;

    //6.这一项是属于哪个订单的
    private String oid;
}
