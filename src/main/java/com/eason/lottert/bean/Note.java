package com.eason.lottert.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @ 文件名:   Note
 * @ 创建者:   Eason
 * @ 时间:    2018/9/30 16:28
 * @ 描述:
 */
@Data
@Entity
public class Note {
    //帖子的编号
    @Id
    private String nid;
    //帖子的标题
    private String title;
    //帖子的内容
    private String content;
    //发帖的时间
    private String time;
    //谁发的帖子
    private String username;
    //发帖人的ip地址
    private String addr;

    @OneToMany(mappedBy = "nid")
    private List<Comment> comments;
}
