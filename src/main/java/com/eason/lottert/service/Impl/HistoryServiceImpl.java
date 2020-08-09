package com.eason.lottert.service.Impl;

import com.eason.lottert.bean.BallHistory;
import com.eason.lottert.dao.HistoryDao;
import com.eason.lottert.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort.Direction;

import java.util.Collections;
import java.util.List;

/**
 * @ 文件名:   IndexServiceImpl
 * @ 创建者:   Eason
 * @ 时间:    2018/9/26 14:33
 * @ 描述:
 */
@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryDao indexDao;

    @Override
    public List<BallHistory> findAll() {
        List<BallHistory> histories = indexDao.findAll();
        Collections.reverse(histories);
        return histories;
    }

    @Override
    public BallHistory find(String code) {
        return indexDao.findOne(code);
    }

    @Override
    public Page<BallHistory> findByPage(Integer pageNumber) {
        return indexDao.findAll(new PageRequest(pageNumber == null ? 0 : pageNumber, 5, new Sort(Direction.DESC, "code")));
    }

}
