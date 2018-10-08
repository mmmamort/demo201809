package com.eason.lottert.controller;

import com.alibaba.fastjson.JSONArray;
import com.eason.lottert.bean.Cart;
import com.eason.lottert.bean.CartItem;
import com.eason.lottert.utils.BallUtils;
import com.eason.lottert.utils.CartUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * @ 文件名:   CartController
 * @ 创建者:   Eason
 * @ 时间:    2018/10/6 23:31
 * @ 描述:
 */
@Controller
@RequestMapping("/select")
public class CartController {
    @GetMapping("/")
    public String index() {
        return "select.html";
    }

    @GetMapping("/showCount")
    @ResponseBody
    public String showCartItem(HttpSession session) {
        Cart cart = CartUtils.Init(session);

        return cart.getSubtotalCount() + "";
    }

    @GetMapping("/add")
    public String add(String ballArr, HttpSession session) {
        Cart cart = CartUtils.Init(session);

        List<CartItem> cartItems = JSONArray.parseArray(ballArr, CartItem.class);
        System.out.println(cartItems);

        for (CartItem cartItem : cartItems) {
            cart.add(cartItem);
        }

        return "redirect:/select/showCount";
    }

    @GetMapping("/delete")
    public String delete(String key, HttpSession session) {
        Cart cart = CartUtils.Init(session);

        cart.remove(key);

        session.setAttribute("cart", cart);

        return "redirect:/select/cart";
    }

    @GetMapping("/randomOne")
    public String randomOne(HttpSession session) {
        Cart cart = CartUtils.Init(session);

        CartItem cartItem = new CartItem();

        cartItem.setRed(BallUtils.redBalls());
        cartItem.setBlue(BallUtils.blueBall());

        cart.add(cartItem);

        session.setAttribute("cart", cart);

        return "redirect:/select/cart";
    }

    @GetMapping("/clear")
    public String clear(HttpSession session) {
        Cart cart = CartUtils.Init(session);

        cart.clear();

        session.setAttribute("cart", cart);

        return "redirect:/select/cart";
    }

    @GetMapping("/cart")
    public String cart(HttpSession session) {
        Cart cart = CartUtils.Init(session);
        return "cart.html";
    }
}
