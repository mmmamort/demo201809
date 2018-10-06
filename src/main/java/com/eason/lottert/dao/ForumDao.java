package com.eason.lottert.dao;

import com.eason.lottert.bean.Note;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ 文件名:   ForumDao
 * @ 创建者:   Eason
 * @ 时间:    2018/9/30 17:04
 * @ 描述:
 */
public interface ForumDao extends JpaRepository<Note, String> {
    Note findByNid(String nid);
}
