package com.eason.lottert.service;

import com.eason.lottert.bean.BallHistory;

import java.util.List;

/**
 * @ 文件名:   IndexService
 * @ 创建者:   Eason
 * @ 时间:    2018/9/26 14:31
 * @ 描述:
 */
public interface IndexService {
    List<BallHistory> findAll();
}
