package com.eason.lottert.bean;

import org.aspectj.weaver.ast.Var;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @ 文件名:   Cart
 * @ 创建者:   Eason
 * @ 时间:    2018/10/7 0:54
 * @ 描述:
 */
public class Cart {
    private Map<String, CartItem> carts = new HashMap<>();

    public void add(CartItem cartItem) {
        String key = cartItem.getRed() + "," + cartItem.getBlue();
        if (carts.containsKey(key)) {
            CartItem cartItemExisted = carts.get(key);
            cartItemExisted.setCount(cartItemExisted.getCount() + 1);
        } else {
            carts.put(key, cartItem);
        }
    }

    public void remove(String key) {
        carts.remove(key);
    }

    public void clear() {
        carts.clear();
    }

    public int getSubtotalCount() {
        int count = 0;
        for (CartItem cartItem : carts.values()) {
            count += cartItem.getCount();
        }
        return count;
    }

    public Collection<CartItem> getCartItems() {
        return carts.values();
    }


    public double getSumSubtotal() {
        double sum = 0;
        for (CartItem cartItem : carts.values()) {
            sum += cartItem.getSubtotal();
        }
        return sum;
    }
}
