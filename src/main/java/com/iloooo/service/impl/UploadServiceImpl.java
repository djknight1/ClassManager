package com.iloooo.service.impl;

import com.iloooo.entity.Homework;
import com.iloooo.entity.Task;
import com.iloooo.entity.Type;
import com.iloooo.entity.User;
import com.iloooo.dao.*;
import com.iloooo.service.UploadService;
import com.iloooo.utils.CONSTANTS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
    public boolean updateHomework(MultipartFile file, long userId, long typeId, long taskId, String serverPath) {
        Homework homework = homeworkDao.selectByUserIdAndTaskId(userId, taskId);
        User user = userDao.selectById(userId);
        Task task = taskDao.selectByTaskId(taskId);
        boolean methodFlag = false;
        String filename = file.getOriginalFilename();
        String homeworkName = user.getId() + " " + user.getName() + "_" + task.getFormatName() + filename.substring(filename.lastIndexOf("."));;
        String path = CONSTANTS.FILE_PATH_PREFIX + task.getTaskPath() + "/" + homeworkName;
        String fullPath = serverPath + path;
        String prefix = fullPath.substring(0, fullPath.lastIndexOf('/') + 1);
        File fileDir=new File(prefix);
        File localFile = new File(serverPath+path);
        if (homework == null) {
            homework = new Homework();
            methodFlag = true;
        }
        homework.setName(homeworkName);
        homework.setUserId(userId);
        homework.setPath(path);
        homework.setTime(new Timestamp(new Date().getTime()));
        homework.setTaskId(taskId);
        homework.setTypeId(typeId);
        fileDir.mkdirs();
        try {

            file.transferTo(localFile);
            System.out.println(localFile);

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        if (methodFlag) {
            homeworkDao.insertHomework(homework);
        } else{
            homeworkDao.updateHomework(homework);
        }


        return true;
    }

}
