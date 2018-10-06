package com.eason.lottert.service.Impl;

import com.eason.lottert.bean.User;
import com.eason.lottert.dao.UserDao;
import com.eason.lottert.service.UserService;
import com.eason.lottert.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ 文件名:   UserServiceImpl
 * @ 创建者:   Eason
 * @ 时间:    2018/9/27 17:16
 * @ 描述:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    //    加密追加字符串
    private String salt = "0x11901";

    @Override
    public void register(User user) {
        String password = user.getPassword();
        password = MD5Utils.encode(password, salt);
        user.setPassword(password);
        userDao.save(user);
    }

    @Override
    public User login(String mobile, String password) {
        password = MD5Utils.encode(password, salt);
        return userDao.findUserByMobileAndPassword(mobile, password);
    }

    @Override
    public User findByUid(String uid) {
        return userDao.findByUid(uid);
    }

    @Override
    public void updata(User user) {
        userDao.save(user);
    }
}
