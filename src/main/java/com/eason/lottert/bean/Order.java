package com.eason.lottert.bean;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ 文件名:   Order
 * @ 创建者:   Eason
 * @ 时间:    2018/10/8 16:17
 * @ 描述:
 */
@Data
@Entity(name = "orders")
public class Order {
    //订单编号
    @Id
    private String oid;

    //订单创建的时间
    private Date createTime;

    //订单状态 : 0 未付款, 1:待开奖, 2:已中奖, 3:已兑奖, 4:未中奖
    private int state;

    //订单总金额
    private double total;

    //所述哪个用户
    private String uid;

    //订单对象要记住所有的订单项对象   cascade 级联  (级联查询)Note ----> 所有评论   (级联更新)
    @OneToMany(mappedBy = "oid", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    public String getCreateTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        return simpleDateFormat.format(createTime);
    }
}
