package com.iloooo.service.impl;


import com.iloooo.entity.User;
import com.iloooo.dao.UserDao;
import com.iloooo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("loginServiceImpl")
public class LoginServiceImpl implements LoginService {
    private final UserDao userDao;

    @Autowired
    public LoginServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserById(long id) {
        return userDao.selectById(id);
    }

    @Override
    public boolean createUser(User user) {
        boolean ret;
        if (isIdEmpty(user.getId())) {
            userDao.insertUser(user);
            ret = true;
        } else {
            ret = false;
        }
        return ret;
    }

    @Override
    public boolean isIdEmpty(long id) {
        return null == userDao.selectById(id);
    }

    @Override
    public boolean isCorrectUser(long id, String password) {
        User user = userDao.selectById(id);
        boolean ret = false;
        if (null != user && user.getPassword().equals(password)) {
            ret = true;
        } else {
            ret = false;
        }
        return ret;
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    public List<User> selectByClassId(int classId){
        return userDao.selectByClassId(classId);
    }

}
