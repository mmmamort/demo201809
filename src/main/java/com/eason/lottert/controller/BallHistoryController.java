package com.eason.lottert.controller;

import com.eason.lottert.bean.BallHistory;
import com.eason.lottert.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ 文件名:   TestController
 * @ 创建者:   Eason
 * @ 时间:    2018/9/25 15:11
 * @ 描述:
 */
@RestController
public class BallHistoryController {

    @Autowired
    private HistoryService historyService;

    @RequestMapping("/ball_history_page")
    public Page<BallHistory> getBallHistoryPages(Integer pageNumber) {
        return historyService.findByPage(pageNumber);
    }

    @RequestMapping("/ball_history_detail")
    public BallHistory getBallHistoryDetail(String code) {
        return historyService.find(code);
    }
}
