package com.iloooo.service.impl;

import com.iloooo.dao.HomeworkDao;
import com.iloooo.entity.Homework;
import com.iloooo.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("homeworkServiceImpl")
public class HomeworkServiceImpl implements HomeworkService {

    private HomeworkDao homeworkDao;

    @Autowired
    public HomeworkServiceImpl(HomeworkDao homeworkDao) {
        this.homeworkDao = homeworkDao;
    }

    @Override
    public boolean newHomework(Homework homework) {
        return homeworkDao.insertHomework(homework);
    }

    @Override
    public boolean removeHomeworkById(long id) {
        return homeworkDao.deleteById(id);
    }

    @Override
    public boolean updateHomework(Homework homework) {
        return homeworkDao.updateHomework(homework);
    }

    @Override
    public List<Homework> getHomeworkAll() {
        return homeworkDao.selectHomeworkAll();
    }

    @Override
    public List<Homework> getHomeworkListByUserId(long userId) {
        return homeworkDao.selectByUserId(userId);
    }

    @Override
    public List<Homework> getHomeworkByTypeId(long typeId) {
        return homeworkDao.selectByTypeId(typeId);
    }

    @Override
    public Homework getHomeworkByUserIdAndTaskId(long userId, long TaskId) {
        return homeworkDao.selectByUserIdAndTaskId(userId, TaskId);
    }

}
