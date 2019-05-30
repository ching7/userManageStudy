package com.cyn.dao;

import com.cyn.bean.User;

public interface UserDao {
    User getUserInfoDao(String name) throws ClassNotFoundException;
}
