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
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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
        int number = page.getNumber();
        model.addAttribute("pageNow", number);

        Note note = forumService.findTheLast();
        model.addAttribute("note", note);

//        List<BallHistory> histories = historyService.findAll();
//        model.addAttribute("histories", histories);
        return "index.html";
    }

//    @GetMapping("/detail")
//    public String detail(HttpServletRequest request, String code, Model model) {
//        for (Map.Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
//
//        System.out.println(code);
////        BallHistory history = historyService.find(code);
////        model.addAttribute("history", history);
//        return "detail.html";
//    }
}
