package com.cyn.service;

import com.cyn.bean.User;

public interface UserService  {
    User getUserInfoService(String name) throws ClassNotFoundException;
}
