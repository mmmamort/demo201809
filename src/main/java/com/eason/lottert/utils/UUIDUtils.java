package com.eason.lottert.utils;

import java.util.UUID;

/**
 * @ 文件名:   UUIDUtils
 * @ 创建者:   Eason
 * @ 时间:    2018/9/27 19:49
 * @ 描述:
 */
public class UUIDUtils {
    /**
     * 随机生成id
     * @return
     */
    public static String getId(){
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    /**
     * 生成随机码
     * @return
     */
    public static String getCode(){
        return getId();
    }

}
