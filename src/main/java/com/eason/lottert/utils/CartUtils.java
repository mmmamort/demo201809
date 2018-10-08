package com.eason.lottert.utils;

import com.eason.lottert.bean.Cart;

import javax.servlet.http.HttpSession;

/**
 * @ 文件名:   CartInitUtils
 * @ 创建者:   Eason
 * @ 时间:    2018/10/8 11:48
 * @ 描述:
 */
public class CartUtils {
    public static Cart Init(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        return cart;
    }
}
