package com.iloooo.service.impl;

import com.iloooo.entity.Homework;
import com.iloooo.entity.Task;
import com.iloooo.entity.Type;
import com.iloooo.entity.User;
import com.iloooo.dao.*;
import com.iloooo.service.UploadService;
import com.iloooo.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Task> getTaskNow() {
        return taskDao.selectTaskNow();
    }


    @Override
    public List<Type> getTypeAll() {
        return typeDao.selectTypeAll();
    }

    @Override
    public boolean updateHomework(MultipartFile file, long userId, long typeId, long taskId, String serverPath) {
        System.out.println(file);

        Homework homework = homeworkDao.selectByUserIdAndTaskId(userId, taskId);
        int methodFlag = 0;
        int fullPathFlag = 0;
        boolean updateFlag = false;
        if (null == homework) {
            homework = new Homework();
            methodFlag = 1;
        }
        User user = userDao.selectById(userId);
        Task task = taskDao.selectByTaskId(taskId);
        String filename = file.getOriginalFilename();
        boolean ret = false;
        String homeworkName = user.getId() + " " + user.getName() + "_" + task.getFormatName() + FileUtils.getFileSuffix(filename);
        String path = FileUtils.FILE_PATH_PREFIX + task.getTaskPath() + "/" + homeworkName;
        String fullPath = serverPath + path;
        for (int i = fullPath.length()-1; i >=0 ; i--) {
            if(fullPath.charAt(i)=='/'){
                fullPathFlag = i;
                break;
            }
        }
        String prefix = fullPath.substring(0, fullPath.lastIndexOf('/') + 1);//fullPathFlag+1);
        System.out.println(prefix);
        File fileDir=new File(prefix);
        File localFile = new File(serverPath+path);
        fileDir.mkdirs();
        try {
            file.transferTo(localFile);
            updateFlag = true;//fileName;
        } catch (IOException e) {
            updateFlag = false;
            e.printStackTrace();
        }

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
