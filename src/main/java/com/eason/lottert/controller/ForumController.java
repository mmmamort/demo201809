package com.eason.lottert.controller;

import com.eason.lottert.bean.BallHistory;
import com.eason.lottert.bean.Comment;
import com.eason.lottert.bean.Note;
import com.eason.lottert.bean.User;
import com.eason.lottert.service.ForumService;
import com.eason.lottert.service.UserService;
import com.eason.lottert.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @ 文件名:   ForumController
 * @ 创建者:   Eason
 * @ 时间:    2018/9/30 10:28
 * @ 描述:
 */
@Controller
@RequestMapping("/forum")
public class ForumController {
    @Autowired
    private ForumService forumService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String forum(Model model, Integer pageNumber) {
        Page<Note> page = forumService.findByPage(pageNumber);
        model.addAttribute("page", page);
        model.addAttribute("pageNow", page.getNumber());

//        List<Note> notes = forumService.findAll();
//        model.addAttribute("notes", notes);
        return "forum_index.html";
    }

    @PostMapping("/add")
    public String add(Note note, HttpSession session, HttpServletRequest request) {
        String uid = (String) session.getAttribute("uid");
        User user = userService.findByUid(uid);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        note.setNid(UUIDUtils.getId());
        note.setTime(dateFormat.format(new Date()));
        note.setUsername(user.getUsername());
        note.setAddr(request.getRemoteAddr());

        forumService.uploadNote(note);

        return "redirect:/forum/";
    }

    @PostMapping("/comment/{nid}")
    public String comment(@PathVariable String nid, Comment comment, HttpSession session, HttpServletRequest request) {
        String uid = (String) session.getAttribute("uid");
        User user = userService.findByUid(uid);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        comment.setNid(nid);
        comment.setTime(dateFormat.format(new Date()));
        comment.setUsername(user.getUsername());
        comment.setAddr(request.getRemoteAddr());

        forumService.uploadComment(comment);

        return "redirect:/forum/note?nid=" + nid;
    }

    @GetMapping("/note")
    public String detail(String nid, Model model) {
        Note note = forumService.findByNid(nid);
        model.addAttribute("note", note);
        return "forum_detail.html";
    }
}
