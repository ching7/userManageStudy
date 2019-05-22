package com.cyn.service;

import com.cyn.pojo.User;

public interface UserService {
    /**
     * 用户登陆校验
     * */
    User checkUserLoginService(String uname,String pwd);
}
