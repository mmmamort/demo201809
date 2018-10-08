package com.eason.lottert.utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @ 文件名:   BallUtils
 * @ 创建者:   Eason
 * @ 时间:    2018/9/30 9:49
 * @ 描述:
 */
public class BallUtils {
    public static String redBalls() {
        Set<Integer> sets = new HashSet<>();
        while (sets.size() < 6) {
            int i = new Random().nextInt(33) + 1;
            sets.add(i);
        }
        String redBalls = "";
        for (Integer i : sets) {
            redBalls += "," + String.format("%02d", i);
        }
        return redBalls.substring(1);
    }

    public static String blueBall() {
        int blueBall = new Random().nextInt(16) + 1;
        return String.format("%02d", blueBall);
    }
}
