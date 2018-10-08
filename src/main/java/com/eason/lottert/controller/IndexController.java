package com.eason.lottert.controller;

import com.eason.lottert.bean.BallHistory;
import com.eason.lottert.bean.Note;
import com.eason.lottert.service.ForumService;
import com.eason.lottert.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.criteria.Order;
import java.util.Collections;
import java.util.List;

/**
 * @ 文件名:   TestController
 * @ 创建者:   Eason
 * @ 时间:    2018/9/25 15:11
 * @ 描述:
 */
@Controller
public class IndexController {

    @Autowired
    private HistoryService historyService;
    @Autowired
    private ForumService forumService;

    @GetMapping("/")
    public String index(Model model, Integer pageNumber) {
        Page<BallHistory> page = historyService.findByPage(pageNumber);
        model.addAttribute("page", page);
        model.addAttribute("pageNow", page.getNumber());

        Note note = forumService.findTheLast();
        model.addAttribute("note", note);

//        List<BallHistory> histories = historyService.findAll();
//        model.addAttribute("histories", histories);
        return "index.html";
    }

    @GetMapping("/detail")
    public String detail(String code, Model model) {
        BallHistory history = historyService.find(code);
        model.addAttribute("history", history);
        return "detail.html";
    }
}
