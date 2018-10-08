package com.eason.lottert.service;

import com.eason.lottert.bean.Comment;
import com.eason.lottert.bean.Note;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @ 文件名:   ForumService
 * @ 创建者:   Eason
 * @ 时间:    2018/9/30 17:02
 * @ 描述:
 */
public interface ForumService {
    void uploadNote(Note note);

    List<Note> findAll();

    Page<Note> findByPage(Integer pageNumber);

    Note findByNid(String nid);

    void uploadComment(Comment comment);

    Note findTheLast();
}
