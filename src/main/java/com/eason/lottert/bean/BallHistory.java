package com.eason.lottert.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @ 文件名:   BallHistory
 * @ 创建者:   Eason
 * @ 时间:    2018/9/26 14:06
 * @ 描述:
 * `code` VARCHAR(30) NOT NULL,
 * `name` VARCHAR(30) DEFAULT NULL,
 * `date` VARCHAR(30) DEFAULT NULL,
 * `week` VARCHAR(30) DEFAULT NULL,
 * `red` VARCHAR(30) DEFAULT NULL,
 * `blue` VARCHAR(30) DEFAULT NULL,
 * `sales` MEDIUMTEXT,
 * `poolmoney` MEDIUMTEXT,
 * `content` VARCHAR(255) DEFAULT NULL,
 * PRIMARY KEY (`code`)
 */
@Data
@Entity(name = "ballhistory")
public class BallHistory {
    @Id
    private String code;
    private String name;
    private String date;
    private String week;
    private String red;
    private String blue;
    private Long sales;
    private Long poolmoney;
    private String content;

    @OneToMany(mappedBy = "code")
    private List<PrizeGrade> prizegrades;
}
