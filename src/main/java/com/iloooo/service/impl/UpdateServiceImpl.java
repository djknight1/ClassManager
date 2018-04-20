package com.iloooo.service.impl;

import com.iloooo.dao.*;
import com.iloooo.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateServiceImpl implements UpdateService {

    private UserDao userDao;
    private HomeworkDao homeworkDao;
    private TypeDao typeDao;
    private TaskDao taskDao;
    private ClassDao classDao;

    @Autowired
    public UpdateServiceImpl(UserDao userDao, HomeworkDao homeworkDao, TypeDao typeDao, TaskDao taskDao, ClassDao classDao) {
        this.userDao = userDao;
        this.homeworkDao = homeworkDao;
        this.typeDao = typeDao;
        this.taskDao = taskDao;
        this.classDao = classDao;
    }
}
