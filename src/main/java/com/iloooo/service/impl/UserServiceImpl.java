package com.iloooo.service.impl;

import com.iloooo.dao.UserDao;
import com.iloooo.entity.User;
import com.iloooo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean newUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return updateUser(user);
    }

    @Override
    public boolean removeUser(long id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public User getUserById(long id) {
        return userDao.selectById(id);
    }

    @Override
    public List<User> getUserByClassId(long classId) {
        return userDao.selectByClassId(classId);
    }

    @Override
    public List<User> getUserAll() {
        return userDao.selectAll();
    }


}
