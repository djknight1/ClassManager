package com.iloooo.service.impl;

import com.iloooo.bean.Admin;
import com.iloooo.bean.Class;
import com.iloooo.bean.Homework;
import com.iloooo.bean.Task;
import com.iloooo.dao.*;
import com.iloooo.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminServiceImpl")
public class AdminServiceImpl implements AdminService {

    private AdminDao adminDao;
    private HomeworkDao homeworkDao;
    private ClassDao classDao;
    private TaskDao taskDao;
    private TypeDao typeDao;
    private UserDao userDao;

    public AdminServiceImpl(AdminDao adminDao, HomeworkDao homeworkDao, ClassDao classDao, TaskDao taskDao, TypeDao typeDao, UserDao userDao) {
        this.adminDao = adminDao;
        this.homeworkDao = homeworkDao;
        this.classDao = classDao;
        this.taskDao = taskDao;
        this.typeDao = typeDao;
        this.userDao = userDao;
    }


    @Override
    public Admin getAdminByUsername(String username) {
        return adminDao.selectByUsername(username);
    }

    @Override
    public boolean isUsernameEmpty(String username) {
        return null == adminDao.selectByUsername(username);
    }

    @Override
    public boolean isCorrectAdmin(String username, String password) {
        Admin admin = adminDao.selectByUsername(username);
        boolean ret = false;
        if (null != admin && admin.getPassword().equals(password)) {
            ret = true;
        } else {
            ret = false;
        }
        return ret;
    }
}
