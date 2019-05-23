package com.cyn.service;

import com.cyn.pojo.User;

import java.util.List;

public interface UserService {
    /**
     * 用户登陆校验
     * */
    User checkUserLoginService(String uname,String pwd);

    /**
     * 修改用户密码
     * @param uid
     * @param newPwd
     * @return
     */
    int userChangePwdService(int uid, String newPwd);

    /**
     * 获取所有用户信息
     * @return
     */
    List<User> showAllUser();
}
