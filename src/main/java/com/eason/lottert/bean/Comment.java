package com.eason.lottert.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @ 文件名:   NoteDetail
 * @ 创建者:   Eason
 * @ 时间:    2018/10/6 16:21
 * @ 描述:
 */
@Entity
@Data
public class Comment {
    //本条评论的编号
    @Id
    @GeneratedValue
    private Integer cid;
    //评论的是哪个主题的帖子
    private String nid;
    //评论的内容
    private String content;
    //评论发表的时间
    private String time;
    //评论者的名称
    private String username;
    //评论者的IP地址
    private String addr;
}
