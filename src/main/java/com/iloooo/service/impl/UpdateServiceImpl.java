package com.iloooo.service.impl;

import com.iloooo.bean.Homework;
import com.iloooo.bean.Task;
import com.iloooo.bean.Type;
import com.iloooo.bean.User;
import com.iloooo.dao.*;
import com.iloooo.service.UpdateService;
import com.iloooo.utils.UpdateFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service("updateServiceImpl")
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


    @Override
    public List<Task> getTaskNow() {
        return taskDao.selectTaskNow();
    }

    @Override
    public List<Type> getTypeAll() {
        return typeDao.selectTypeAll();
    }

    @Override
    public boolean updateHomework(long userId, long typeId, long taskId, String username) {
        Homework homework = new Homework();
        User user = userDao.selectById(userId);
        Type type = typeDao.selectTypeById(typeId);
        Task task = taskDao.selectByTaskId(taskId);
        boolean ret = false;
        String homeworkName = user.getId() + " " + user.getName() + "_" + task.getFormatName() + UpdateFileUtils.getFileSuffix(username);
        String path = UpdateFileUtils.FILE_PATH_PREFIX + homeworkName;
        ///....Do write file work
        if (UpdateFileUtils.update()) {
            homework.setName(homeworkName);
            homework.setUserId(userId);
            homework.setPath(path);
            homework.setDatetime(new Timestamp(new Date().getTime()));
            homework.setTaskId(taskId);
            homework.setTypeId(typeId);
            homeworkDao.insertHomework(homework);
            ret = true;
        } else {
            ret = false;
        }
        return ret;
    }
}
