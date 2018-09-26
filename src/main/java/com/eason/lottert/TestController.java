package com.eason.lottert;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ 文件名:   TestController
 * @ 创建者:   Eason
 * @ 时间:    2018/9/25 15:11
 * @ 描述:
 */
@Controller
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "test.html";
    }
}
