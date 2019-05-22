package com.cyn.dao;

import com.cyn.pojo.User;

public interface UserDao {
    /**
     * 根据账号，密码查询数据库
     * */
    User checkUserLoginDao(String uname, String pwd);
}
