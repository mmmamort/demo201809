package com.eason.lottert.dao;

import com.eason.lottert.bean.BallHistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ 文件名:   HistoryDao
 * @ 创建者:   Eason
 * @ 时间:    2018/9/26 14:34
 * @ 描述:
 */
public interface HistoryDao extends JpaRepository<BallHistory, String> {
}
