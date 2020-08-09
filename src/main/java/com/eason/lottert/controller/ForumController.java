package com.eason.lottert.controller;

import com.eason.lottert.bean.Comment;
import com.eason.lottert.bean.Note;
import com.eason.lottert.bean.User;
import com.eason.lottert.service.ForumService;
import com.eason.lottert.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ 文件名:   TestController
 * @ 创建者:   Eason
 * @ 时间:    2018/9/25 15:11
 * @ 描述:
 */
@RestController
@RequestMapping("/forum")
public class ForumController {

    @Autowired
    private UserService userService;
    @Autowired
    private ForumService forumService;

    @RequestMapping("/newest")
    public Note getForumNewest() {
        return forumService.findTheLast();
    }

    @PutMapping("/comment/add")
    public void addForumComment(HttpServletRequest request, HttpSession session, String content, String nid) {
        String uid = (String) session.getAttribute("uid");
        User user = userService.findByUid(uid);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Comment comment = new Comment();
        comment.setContent(content);
        comment.setNid(nid);
        comment.setTime(dateFormat.format(new Date()));
        if (user != null)
            comment.setUsername(user.getUsername());
        comment.setAddr(request.getRemoteAddr());

        forumService.uploadComment(comment);
    }
}
