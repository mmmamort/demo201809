package com.eason.lottert.service;

import com.eason.lottert.bean.User;

import java.util.List;

/**
 * @ 文件名:   UserService
 * @ 创建者:   Eason
 * @ 时间:    2018/9/27 17:15
 * @ 描述:
 */
public interface UserService {
    void register(User user);

    User login(String mobile, String password);

    User findByUid(String uid);

    void updata(User user);
}
