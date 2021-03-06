package com.eason.lottert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @ 文件名:   main
 * @ 创建者:   Eason
 * @ 时间:    2018/9/24 17:31
 * @ 描述:
 */
@SpringBootApplication
@ServletComponentScan
public class LotteryMain {
    public static void main(String[] args) {
        SpringApplication.run(LotteryMain.class, args);
    }
}
