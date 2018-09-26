package com.eason.lottert.service.Impl;

import com.eason.lottert.bean.BallHistory;
import com.eason.lottert.dao.IndexDao;
import com.eason.lottert.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ 文件名:   IndexServiceImpl
 * @ 创建者:   Eason
 * @ 时间:    2018/9/26 14:33
 * @ 描述:
 */
@Service
public class IndexServiceImpl implements HistoryService {
    @Autowired
    private IndexDao indexDao;

    @Override
    public List<BallHistory> findAll() {
        return indexDao.findAll();
    }
}
