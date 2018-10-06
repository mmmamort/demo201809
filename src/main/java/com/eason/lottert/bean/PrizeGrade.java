package com.eason.lottert.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @ 文件名:   PrizeGrade
 * @ 创建者:   Eason
 * @ 时间:    2018/9/26 17:52
 * @ 描述:
 * `pid` INT(11) NOT NULL AUTO_INCREMENT,
 * `code` VARCHAR(30) DEFAULT NULL,
 * `type` INT(11) DEFAULT NULL,
 * `typenum` INT(11) DEFAULT NULL,
 * `typemoney` MEDIUMTEXT,
 * PRIMARY KEY (`pid`)
 */
@Data
@Entity(name = "prizegrade")
public class PrizeGrade {
    @Id
    private int pid;
    private String code;
    private int type;
    private int typenum;
    private String typemoney;
}
