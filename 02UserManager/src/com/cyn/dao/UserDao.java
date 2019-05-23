package com.cyn.dao;

import com.cyn.pojo.User;

import java.util.List;

public interface UserDao {
    /**
     * 根据账号，密码查询数据库
     * */
    User checkUserLoginDao(String uname, String pwd);
    /**
     * 修改密码
     */
    int userChangePwdDao(int uid, String newPwd);

    /**
     * 获取所有用户
     * @return
     */
    List<User> showAllUserDao();
}
