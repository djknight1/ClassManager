package com.iloooo.service;

import com.iloooo.bean.Task;
import com.iloooo.bean.Type;
import com.iloooo.bean.User;
import com.iloooo.dao.UserDao;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.List;

public interface UploadService {
    List<Task> getTaskNow();

    List<Type> getTypeAll();

    boolean updateHomework(MultipartFile file,long userId, long typeId, long taskId,String serverPath);

}
