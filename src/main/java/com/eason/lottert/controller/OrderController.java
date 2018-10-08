package com.eason.lottert.controller;

import com.eason.lottert.bean.Cart;
import com.eason.lottert.bean.CartItem;
import com.eason.lottert.bean.Order;
import com.eason.lottert.bean.OrderItem;
import com.eason.lottert.service.OrderService;
import com.eason.lottert.utils.CartUtils;
import com.eason.lottert.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ 文件名:   OrderController
 * @ 创建者:   Eason
 * @ 时间:    2018/10/8 16:09
 * @ 描述:
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public String index(HttpSession session) {
        return "pay.html";
    }

    @GetMapping("/save")
    public String save(HttpSession session) {
        String uid = (String) session.getAttribute("uid");
        Cart cart = CartUtils.Init(session);

        Order order = new Order();
        order.setOid(UUIDUtils.getId());
        order.setTotal(cart.getSumSubtotal());
        order.setState(0);
        order.setUid(uid);
        order.setCreateTime(new Date());

        List<OrderItem> orderItems = new ArrayList<>();

        for (CartItem cartItem : cart.getCartItems()) {
            OrderItem orderItem = new OrderItem();

            orderItem.setItemid(UUIDUtils.getId());
            orderItem.setCode("2018035");
            orderItem.setRed(cartItem.getRed());
            orderItem.setBlue(cartItem.getBlue());
            orderItem.setCount(cartItem.getCount());
            orderItem.setSubtotal(cartItem.getSubtotal());
            orderItem.setOid(order.getOid());

            orderItems.add(orderItem);
        }

        order.setOrderItems(orderItems);

        orderService.save(order);

        session.setAttribute("order", order);

        return "redirect:/order/";
    }

    @GetMapping("/list")
    public String list(HttpSession session, Model model) {
        String uid = (String) session.getAttribute("uid");
        List<Order> orders = orderService.findOrder(uid);
        model.addAttribute("orders", orders);
        return "order_list.html";
    }
}
