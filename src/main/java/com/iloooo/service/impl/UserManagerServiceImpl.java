package com.iloooo.service.impl;


import com.iloooo.bean.User;
import com.iloooo.dao.UserDao;
import com.iloooo.service.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userServiceImpl")
public class UserManagerServiceImpl implements UserManagerService {
    private final UserDao userDao;

    @Autowired
    public UserManagerServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public User getUserByUsername(String username) {
        return userDao.selectByUsername(username);
    }

    @Override
    public User getUserById(long id) {
        return userDao.selectById(id);
    }

    @Override
    public boolean createUser(User user) {
        boolean ret;
        if (isUsernameEmpty(user.getUsername())) {
            userDao.insertUser(user);
            ret = true;
        } else {
            ret = false;
        }
        return ret;
    }

    @Override
    public boolean isUsernameEmpty(String username) {
        return null == userDao.selectByUsername(username);
    }

    @Override
    public boolean isCorrectUser(String username, String password) {
        User user = userDao.selectByUsername(username);
        boolean ret = false;
        if (null != user && user.getPassword().equals(password)) {
            ret = true;
        } else {
            ret = false;
        }


        return ret;
    }


}
