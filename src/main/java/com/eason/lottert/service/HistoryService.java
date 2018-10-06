package com.eason.lottert.service;

import com.eason.lottert.bean.BallHistory;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @ 文件名:   HistoryService
 * @ 创建者:   Eason
 * @ 时间:    2018/9/26 14:31
 * @ 描述:
 */
public interface HistoryService {
    List<BallHistory> findAll();

    BallHistory find(String code);

    Page<BallHistory> findByPage(Integer pageNumber);
}
