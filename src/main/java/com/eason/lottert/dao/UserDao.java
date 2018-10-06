package com.eason.lottert.dao;

import com.eason.lottert.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @ 文件名:   UserDao
 * @ 创建者:   Eason
 * @ 时间:    2018/9/27 19:33
 * @ 描述:
 */
public interface UserDao extends JpaRepository<User, String> {
    //    通过手机与密码查找用户
//    @Query("from User  where mobile = ?1 and password = ?2")
    User findUserByMobileAndPassword(String mobile, String password);

    User findByUid(String uid);
}
