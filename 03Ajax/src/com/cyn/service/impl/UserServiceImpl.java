package com.cyn.service.impl;

import com.cyn.bean.User;
import com.cyn.dao.UserDao;
import com.cyn.dao.impl.UserDaoImpl;
import com.cyn.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public User getUserInfoService(String name) throws ClassNotFoundException {
        User user= userDao.getUserInfoDao(name);
        return user;
    }
}
