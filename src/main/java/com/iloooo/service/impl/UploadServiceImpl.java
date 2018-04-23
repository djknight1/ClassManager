package com.iloooo.service.impl;

import com.iloooo.bean.Homework;
import com.iloooo.bean.Task;
import com.iloooo.bean.Type;
import com.iloooo.bean.User;
import com.iloooo.dao.*;
import com.iloooo.service.UploadService;
import com.iloooo.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service("updateServiceImpl")
public class UploadServiceImpl implements UploadService {

    private UserDao userDao;
    private HomeworkDao homeworkDao;
    private TypeDao typeDao;
    private TaskDao taskDao;
    private ClassDao classDao;

    @Autowired
    public UploadServiceImpl(UserDao userDao, HomeworkDao homeworkDao, TypeDao typeDao, TaskDao taskDao, ClassDao classDao) {
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
    public boolean updateHomework(MultipartFile file, long userId, long typeId, long taskId, String serverPath) {
        Homework homework = homeworkDao.selectByUserIdAndTaskId(userId, taskId);
        int methodFlag = 0;
        if (null == homework) {
            homework = new Homework();
            methodFlag = 1;
        }
        User user = userDao.selectById(userId);
        Task task = taskDao.selectByTaskId(taskId);
        String filename = file.getOriginalFilename();
        boolean ret = false;
        String homeworkName = user.getId() + " " + user.getName() + "_" + task.getFormatName() + FileUtils.getFileSuffix(filename);
        String path = FileUtils.FILE_PATH_PREFIX + task.getTaskPath() + "\\" + homeworkName;
        ///WEB-INF/file/2222/1160299021sfdsfsd.doc
        ///....Do write file work
        boolean updateFlag = FileUtils.update(file, path, serverPath);
        homework.setName(homeworkName);
        homework.setUserId(userId);
        homework.setPath(path);
        homework.setTime(new Timestamp(new Date().getTime()));
        homework.setTaskId(taskId);
        homework.setTypeId(typeId);
        if (updateFlag && methodFlag == 1) {
            homeworkDao.insertHomework(homework);
            ret = true;
        } else if (updateFlag && methodFlag == 0) {
            homeworkDao.updateHomework(homework);
            ret = true;
        } else {
            ret = false;
        }
        return ret;
    }

    @Override
    public Task getTaskByTypeId(long typeId ) {
        return taskDao.selectTaskNowByTypeId(typeId);
    }

}
