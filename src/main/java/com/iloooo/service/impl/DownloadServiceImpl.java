package com.iloooo.service.impl;

import com.iloooo.entity.Class;
import com.iloooo.entity.Homework;
import com.iloooo.entity.Task;
import com.iloooo.entity.Type;
import com.iloooo.dao.ClassDao;
import com.iloooo.dao.HomeworkDao;
import com.iloooo.dao.TaskDao;
import com.iloooo.dao.TypeDao;
import com.iloooo.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("downloadServiceImpl")
public class DownloadServiceImpl implements DownloadService {
    private TaskDao taskDao;
    private HomeworkDao homeworkDao;
    private ClassDao classDao;
    private TypeDao typeDao;

    @Autowired
    public DownloadServiceImpl(TaskDao taskDao, HomeworkDao homeworkDao, ClassDao classDao, TypeDao typeDao) {
        this.taskDao = taskDao;
        this.homeworkDao = homeworkDao;
        this.classDao = classDao;
        this.typeDao = typeDao;
    }

    @Override
    public List<Task> getTaskNow() {
        return taskDao.selectTaskNow();
    }

    @Override
    public List<Homework> getHomewordByTaskId(long taskId) {
        return homeworkDao.selectByTaskId(taskId);
    }

    @Override
    public List<Class> getClassAll() {
        return classDao.selectClassAll();
    }

    @Override
    public List<Type> getTypeAll() {
        return typeDao.selectTypeAll();
    }

    @Override
    public List<Task> getTaskByTypeId(long typeId) {
        return taskDao.selectTaskByTypeId(typeId);
    }

}
